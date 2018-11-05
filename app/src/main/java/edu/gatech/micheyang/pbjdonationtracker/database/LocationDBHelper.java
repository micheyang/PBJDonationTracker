package edu.gatech.micheyang.pbjdonationtracker.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.micheyang.pbjdonationtracker.db_model.Item;
import edu.gatech.micheyang.pbjdonationtracker.db_model.Location;
import edu.gatech.micheyang.pbjdonationtracker.db_model.User;

public class LocationDBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "Location.db";
    private static final String LOCN_TABLE = "Location";

    private static final String ID_COL = "id";
    private static final String KEY_COL = "locKey";
    private static final String NAME_COL = "name";
    private static final String LAT_COL = "latitude";
    private static final String LON_COL = "longitude";
    private static final String ADDR_COL = "address";
    private static final String CITY_COL = "city";
    private static final String STATE_COL = "state";
    private static final String ZIP_COL = "zip";
    private static final String TYPE_COL = "type";
    private static final String PHONE_COL = "phone";
    private static final String WEB_COL = "website";
    private static final String NUM_ITEMS_COL = "numItems";

    private String CREATE_LT = "CREATE TABLE " + LOCN_TABLE + "(" + ID_COL
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_COL + " INTEGER,"
            + NAME_COL + " TEXT," + LAT_COL + " TEXT," + LON_COL + " TEXT,"
            + ADDR_COL + " TEXT," + CITY_COL + " TEXT," + STATE_COL + " TEXT,"
            + ZIP_COL + " TEXT," + TYPE_COL + " TEXT," + PHONE_COL + " TEXT,"
            + WEB_COL + " TEXT," + NUM_ITEMS_COL + " INTEGER" + ")";

    private String DROP_LT = "DROP TABLE IF EXISTS " + LOCN_TABLE;

    public LocationDBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_LT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_LT);
        onCreate(db);
    }

    public void addLocation(Location loc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_COL, loc.getKey());
        values.put(NAME_COL, loc.getName());
        values.put(LAT_COL, loc.getLatitude());
        values.put(LON_COL, loc.getLongitude());
        values.put(ADDR_COL, loc.getStreetAddress());
        values.put(CITY_COL, loc.getCity());
        values.put(STATE_COL, loc.getState());
        values.put(ZIP_COL, loc.getZipCode());
        values.put(TYPE_COL, loc.getType());
        values.put(PHONE_COL, loc.getPhoneNumber());
        values.put(WEB_COL, loc.getWebsite());
        values.put(NUM_ITEMS_COL, loc.getInventory().size());
        db.insert(LOCN_TABLE, null, values);
        db.close();
    }

    public void removeLocation(Location loc) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(LOCN_TABLE, ID_COL + " = ?", new String[] {
                String.valueOf(loc.getId())
        });
        db.close();
    }

    public void updateLocation(Location loc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_COL, loc.getKey());
        values.put(NAME_COL, loc.getName());
        values.put(LAT_COL, loc.getLatitude());
        values.put(LON_COL, loc.getLongitude());
        values.put(ADDR_COL, loc.getStreetAddress());
        values.put(CITY_COL, loc.getCity());
        values.put(STATE_COL, loc.getState());
        values.put(ZIP_COL, loc.getZipCode());
        values.put(TYPE_COL, loc.getType());
        values.put(PHONE_COL, loc.getPhoneNumber());
        values.put(WEB_COL, loc.getWebsite());
        values.put(NUM_ITEMS_COL, loc.getInventory().size());
        db.update(LOCN_TABLE, values, ID_COL + " = ?", new String[] {
                String.valueOf(loc.getId())
        });
        db.close();
    }

    public boolean checkLocation(String name) {
        if (name == null) {
            return false;
        }
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = { ID_COL };
        String col = NAME_COL + " = ?";
        String[] arg = { name };

        Cursor cursor = db.query(LOCN_TABLE, cols, col, arg, null,
                null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return (count > 0);
    }

    public boolean checkEmployeeList(String name, User user) {
        if (user == null || name == null || (!user.getType().equals("EMPLOYEE"))) {
            return false;
        }
        List<Location> list = locationList();
        for (Location loc : list) {
            if (loc.getName().equals(name)) {
                return loc.getEmployeeList().contains(user);
            }
        }
        return false;
    }

    public String getLocationType(String name) {
        if (name == null) {
            return null;
        } else if (!checkLocation(name)) {
            return null;
        }
        List<Location> list = locationList();
        for (Location loc : list) {
            if (loc.getName().equals(name)) {
                return loc.getType();
            }
        }
        return null;
    }

    public boolean isEmpty() {
//        boolean result = true;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor query = db.rawQuery("SELECT count(*) FROM " + LOCN_TABLE +" WHERE name = "
//                + LOCN_TABLE, null);
//        if (query.moveToFirst()) { //if table exists, check if it has rows/entries
//            query = db.rawQuery("SELECT count(*) FROM " + LOCN_TABLE, null);
//            if (query.moveToFirst()) { //exists, if true then table also has rows (entries)
//                result = false;
//            }
//        }
//        query.close();
//        db.close();
        List<Location> locn_list = locationList();
        return locn_list.isEmpty();
    }

    public Location findByKey(int i) {
        if (i == -1) return null;
        for (Location loc : locationList()) {
            if (loc.getKey() == i) {
                return loc;
            }
        }
        return null;
    }


    public List<Location> locationList() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Location> list = new ArrayList<>();

        String[] cols = { ID_COL, KEY_COL, NAME_COL, LAT_COL, LON_COL, ADDR_COL, CITY_COL, STATE_COL,
                ZIP_COL, TYPE_COL, PHONE_COL, WEB_COL, NUM_ITEMS_COL };
        String orderBy = NAME_COL + " ASC";

        Cursor cursor = db.query(LOCN_TABLE, cols, null,
                null, null, null, orderBy);
        if (cursor.moveToFirst()) {
            do {
                Location loc = new Location();
                loc.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID_COL))));
                loc.setKey(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_COL))));
                loc.setName(cursor.getString(cursor.getColumnIndex(NAME_COL)));
                loc.setLatitude(cursor.getString(cursor.getColumnIndex(LAT_COL)));
                loc.setLongitude(cursor.getString(cursor.getColumnIndex(LON_COL)));
                loc.setStreetAddress(cursor.getString(cursor.getColumnIndex(ADDR_COL)));
                loc.setCity(cursor.getString(cursor.getColumnIndex(CITY_COL)));
                loc.setState(cursor.getString(cursor.getColumnIndex(STATE_COL)));
                loc.setZipCode(cursor.getString(cursor.getColumnIndex(ZIP_COL)));
                loc.setType(cursor.getString(cursor.getColumnIndex(TYPE_COL)));
                loc.setPhoneNumber(cursor.getString(cursor.getColumnIndex(PHONE_COL)));
                loc.setWebsite(cursor.getString(cursor.getColumnIndex(WEB_COL)));
                //*** make get list inventory method to set loc inventory properly *****
                loc.setInventory(new ArrayList<Item>(cursor.getColumnIndex(NUM_ITEMS_COL)));

                list.add(loc);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

}