package edu.gatech.micheyang.pbjdonationtracker.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.micheyang.pbjdonationtracker.db_model.User;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "User.db";
    private static final String USER_TABLE = "User";

    private static final String ID_COL = "id";
    private static final String USERNAME_COL = "username";
    private static final String PASSWORD_COL = "password";
    private static final String EMAIL_COL = "email";
    private static final String LOCKED_COL = "locked";
    private static final String TYPE_COL = "type";

    private String CREATE_UT = "CREATE TABLE " + USER_TABLE + "("
            + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT," + USERNAME_COL
            + " TEXT," + PASSWORD_COL + " TEXT," + EMAIL_COL + " TEXT,"
            + LOCKED_COL + " TEXT," + TYPE_COL + " TEXT" + ")";
    private String DROP_UT = "DROP TABLE IF EXISTS " + USER_TABLE;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_UT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DROP_UT);
        onCreate(db);
    }

    /**
     * Add the inputted user's info to the users database.
     *
     * Stores their data in a row, to be added onto the existing table of user
     * information in database.
     * @param user the User object to be added in database.
     */
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERNAME_COL, user.getUsername());
        values.put(EMAIL_COL, user.getEmail());
        values.put(PASSWORD_COL, user.getPassword());
        String state = (user.getLocked() ? "true" : "false");
        values.put(LOCKED_COL, state);
        int pos = User.findTypeIndex(user.getType());
        values.put(TYPE_COL, User.types.get(pos));
        //add user info, put in table as new row
        db.insert(USER_TABLE, null, values);
        db.close();
    }

    public void removeUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(USER_TABLE, ID_COL + " = ?", new String[] {
                String.valueOf(user.getId())
        });
        db.close();
    }

    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERNAME_COL, user.getUsername());
        values.put(EMAIL_COL, user.getEmail());
        values.put(PASSWORD_COL, user.getPassword());
        String state = (user.getLocked() ? "true" : "false");
        values.put(LOCKED_COL, state);
        int pos = User.findTypeIndex(user.getType());
        values.put(TYPE_COL, User.types.get(pos));
        db.update(USER_TABLE, values, ID_COL + " = ?", new String[] {
                String.valueOf(user.getId())
        });
        db.close();

    }

    public boolean checkUsername(String username) {
        if (username == null) {
            return false;
        }
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = { ID_COL };
        String col = USERNAME_COL + " = ?";
        String[] arg = { username };

        Cursor cursor = db.query(USER_TABLE, cols, col, arg, null,
                null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return (count > 0);
    }

    public String getUserType(String username) {
        if (username == null) {
            return null;
        } else if (!checkUsername(username)) {
            return null;
        }
        List<User> list = userList();
        for (User u : list) {
            if (u.getUsername().equals(username)) {
                return u.getType();
            }
        }
        return null;
    }

    public boolean checkEmail(String email) {
        if (email == null) {
            return false;
        }
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = { ID_COL };
        String col = EMAIL_COL + " = ?";
        String[] arg = { email };

        Cursor cursor = db.query(USER_TABLE, cols, col, arg, null,
                null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return (count > 0);
    }

    public boolean checkUserPass(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = { ID_COL };
        String col = USERNAME_COL + " = ?" + " AND " + PASSWORD_COL + " = ?";
        String[] arg = { username, password };

        Cursor cursor = db.query(USER_TABLE, cols, col, arg, null,
                null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return (count > 0);
    }

    public List<User> userList() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<User> list = new ArrayList<>();

        String[] cols = { ID_COL, USERNAME_COL, EMAIL_COL, PASSWORD_COL, LOCKED_COL, TYPE_COL };
        String orderBy = USERNAME_COL + " ASC";

        Cursor cursor = db.query(USER_TABLE, cols, null,
                null, null, null, orderBy);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID_COL))));
                user.setUsername(cursor.getString(cursor.getColumnIndex(USERNAME_COL)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(EMAIL_COL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(PASSWORD_COL)));
                String lock = (cursor.getString(cursor.getColumnIndex(LOCKED_COL)));
                user.setLocked(lock.equals("true"));
                user.setType(cursor.getString(cursor.getColumnIndex(TYPE_COL)));

                list.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

}