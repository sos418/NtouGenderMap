package com.example.a1216qdf.ntougendermap;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 1216QDF on 11/30/2016.
 */
class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "starbuzz"; // the name of our database
    private static final int DB_VERSION = 2; // the version of the database

    DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "LATITUDE REAL, "
                    + "LONGITUDE REAL);");
            insertMark(db, "廁所", 150.5, 1865.5);
            insertMark(db, "廁所", 130.4, 500.1);
        }
//        insertMark(db, "Filter", "Our best drip coffee", R.drawable.filter);
        insertMark(db, "廁所", 600.4,600.5);
        insertMark(db, "飲水機", 1000.1,1000.2);
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;");
        }
    }

    private static void insertMark(SQLiteDatabase db, String name,
                                    Double latitude, Double longitude) {
        ContentValues markValues = new ContentValues();
        markValues.put("NAME", name);
        markValues.put("LATITUDE", latitude);
        markValues.put("LONGITUDE", longitude);
        db.insert("DRINK", null, markValues);
    }
}
