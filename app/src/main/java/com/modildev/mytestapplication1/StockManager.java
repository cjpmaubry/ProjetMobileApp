package com.modildev.mytestapplication1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class StockManager {
    private static final String TABLE_NAME = "Stock";
    public static final String id = "id";
    public static final String type = "type";
    public static final String quantity = "quantity";
    public static final String warehouseID = "warehouseID";
    public static final String CREATE_TABLE_STOCK = "CREATE TABLE "
            + TABLE_NAME + " ("
            + id + " INTEGER primary key, "
            + type + " TEXT, "
            + quantity + " TEXT, "
            + warehouseID + "TEXT);";
    private SQLiteDatabase db;
    private MySQLite myBase;

    public StockManager(Context context){
        myBase = MySQLite.getInstance(context);
    }

    public void open(){
        db = myBase.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

}
