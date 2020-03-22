package com.modildev.mytestapplication1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ParameterManager {
    private static final String TABLE_NAME = "Stock";
    public static final String id = "id";
    public static final String intP = "intparameter";
    public static final String strP = "strParameter";
    public static final String CREATE_TABLE_PARAMETER = "CREATE TABLE "
            + TABLE_NAME + " ("
            + id + " INTEGER primary key AUTOINCREMENT, "
            + intP + " INTEGER, "
            + strP + " TEXT);";
    private SQLiteDatabase db;
    private MySQLite myBase;

    public ParameterManager(Context context){
        myBase = MySQLite.getInstance(context);
    }

    public void open(){
        db = myBase.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public long addIntParameter(int intParameter){
        ContentValues values = new ContentValues();
        values.put(intP, intParameter);
        values.put(strP, "");
        return db.insert(TABLE_NAME, null, values);
    }

    public long addStrParameter(String strParameter){
        ContentValues values = new ContentValues();
        values.put(intP, 0);
        values.put(strP, strParameter);
        return db.insert(TABLE_NAME, null, values);
    }

    private int getLastId(){
        int lastId= 0;
        Cursor c = db.rawQuery("SELECT MAX(" + id + ") FROM " + TABLE_NAME, null);
        if (c.moveToFirst()){
            lastId = c.getInt(c.getColumnIndex(id));
        }
        return lastId;
    }

    public int getLastIntP(){
        int lastId = getLastId();
        int lastIntP = 0;
        Cursor c = db.rawQuery("SELECT " + intP + " FROM " + TABLE_NAME + " WHERE " + id + "=?",new String[]{Integer.toString(lastId)});
        if (c.moveToFirst()){
            lastIntP = c.getInt(c.getColumnIndex(intP));
        }
        return lastIntP;
    }

    public String getLastStrP(){
        int lastId = getLastId();
        String lastStrP = "";
        Cursor c = db.rawQuery("SELECT " + strP + " FROM " + TABLE_NAME + " WHERE " + id + "=?",new String[]{Integer.toString(lastId)});
        if (c.moveToFirst()){
            lastStrP = c.getString(c.getColumnIndex(strP));
        }
        return lastStrP;
    }
}
