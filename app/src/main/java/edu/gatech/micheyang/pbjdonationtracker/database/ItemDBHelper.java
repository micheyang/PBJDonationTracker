/*
package edu.gatech.micheyang.pbjdonationtracker.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.micheyang.pbjdonationtracker.db_model.Item;

public class ItemDBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "Item.db";
    private static final String ITEM_TABLE = "Item";

    private static final String KEY_COL = "key";
    private static final String TIME_COL = "time";
    private static final String LOCATION_COL = "location";
    private static final String SHORT_DESC_COL = "short description";
    private static final String FULL_DESC_COL = "full description";
    private static final String VALUE_COL = "value";
    private static final String CATEGORY_COL = "category";

    private String CREATE_UT = "CREATE TABLE " + ITEM_TABLE + "("
            + KEY_COL + " INTEGER PRIMARY KEY AUTOINCREMENT," + TIME_COL + " TEXT" + LOCATION_COL
            + " TEXT," + SHORT_DESC_COL + " TEXT," + FULL_DESC_COL + " TEXT,"
            + VALUE_COL + " TEXT," + CATEGORY_COL + " TEXT" + ")";
    private String DROP_UT = "DROP TABLE IF EXISTS " + ITEM_TABLE;

    public ItemDBHelper(Context context) {
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

    */
/**
     * Add the inputted item's info to the items database.
     *
     * Stores the data in a row, to be added onto the existing table of item
     * information in database.
     * @param item the Item object to be added in database.
     *//*

    public void addItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TIME_COL, item.getTime());
        values.put(LOCATION_COL, item.getLocation());
        values.put(SHORT_DESC_COL, item.getShortDescription());
        values.put(FULL_DESC_COL, item.getFullDescription());
        values.put(VALUE_COL, item.getValue());
        values.put(CATEGORY_COL, item.getCategory());

        //add item info, put in table as new row
        db.insert(ITEM_TABLE, null, values);
        db.close();
    }

}
*/
