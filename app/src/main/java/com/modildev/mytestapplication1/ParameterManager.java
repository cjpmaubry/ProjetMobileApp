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
    private static final String TABLE_NAME = "Parameters";
    public static final String id = "id";
    public static final String parameter1 = "parameter1";
    public static final String CREATE_TABLE_PARAMETER = "CREATE TABLE "
            + TABLE_NAME + " ("
            + id + " INTEGER primary key AUTOINCREMENT, "
            + parameter1 + " INTEGER);";
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

    public long addParameter(Parameter p){
        ContentValues values = new ContentValues();
        //values.put(id, s.getId());
        values.put(parameter1, p.getParameter1());
        return db.insert(TABLE_NAME, null, values);
    }

    public int getLastId(){
        int lastId= 0;
        ArrayList<Integer> idList = new ArrayList<Integer>();
        Cursor c = db.rawQuery("SELECT " + id + " FROM " + TABLE_NAME, null);
        while (c.moveToNext()){
            idList.add(c.getInt(c.getColumnIndex(id)));
        }
        lastId = getMax(idList);
        return lastId;
    }

    public int getMax(ArrayList<Integer> list){
        int max = 0;
        for (int id: list){
            if (id > max)
                max = id;
        }
        return max;
    }

    public int getLastP(){
        int lastId = getLastId();
        int lastP = 0;
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + id + "=?",new String[]{Integer.toString(lastId)});
        if (c.moveToFirst()){
            lastP = c.getInt(c.getColumnIndex(parameter1));
        }
        return lastP;
    }


}
