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
    public static final String iparameter = "iparameter";
    public static final String sparameter = "sparameter";
    public static final String CREATE_TABLE_PARAMETER = "CREATE TABLE "
            + TABLE_NAME + " ("
            + id + " INTEGER primary key AUTOINCREMENT, "
            + iparameter + " INTEGER, "
            + sparameter+ " TEXT);";
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
        values.put(iparameter, p.getIparameter());
        values.put(sparameter, p.getSparameter());
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

    public Parameter getLastP(){
        int lastId = getLastId();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + id + "=?",new String[]{Integer.toString(lastId)});
        if (c.moveToFirst()){
            int lastIntP = c.getInt(c.getColumnIndex(iparameter));
            String lastStrP = c.getString(c.getColumnIndex(sparameter));
            Parameter p = new Parameter(lastIntP, lastStrP);
            return p;
        }
        return null;
    }


}
