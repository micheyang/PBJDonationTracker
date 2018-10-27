package edu.gatech.micheyang.pbjdonationtracker.SQLDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "User.db";
    private static final String USER_TABLE = "User";

    private static final String ID_COL = "id";
    private static final String USERNAME_COL = "username";
    private static final String PASSWORD_COL = "password";
    private static final String EMAIL_COL = "email";
    private static final String LOCKED_COL = "locked";

    private String CREATE_UT = "CREATE TABLE " + USER_TABLE + "("
            + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT," + USERNAME_COL
            + " TEXT," + PASSWORD_COL + " TEXT," + EMAIL_COL + " TEXT,"
            + LOCKED_COL + " TEXT" + ")";
    private String DROP_UT = "DROP TABLE IF EXISTS " + USER_TABLE;

    // constructor, uses super for reference
    public DatabaseHelper(@Nullable Context context, @Nullable String name,
                          @Nullable SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, USER_TABLE, null, VERSION);
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
        values.put(PASSWORD_COL, user.getPassword());
        values.put(EMAIL_COL, user.getEmail());
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
        String col = USERNAME_COL + " = ?" + " AND " + PASSWORD_COL;
        String[] arg = { username, password };

        Cursor cursor = db.query(USER_TABLE, cols, col, arg, null,
                null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return (count > 0);
    }

}