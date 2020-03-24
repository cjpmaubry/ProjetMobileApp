package com.modildev.mytestapplication1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLite extends SQLiteOpenHelper {
    private static final String DBName = "Management.db";
    private static final int DBVersion = 1;
    private static MySQLite instance;

    public static synchronized MySQLite getInstance(Context context){
        if (instance == null)
            instance = new MySQLite(context);
        return instance;
    }

    private MySQLite(Context context){
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //creates the databases and the following tables
        sqLiteDatabase.execSQL(StockManager.CREATE_TABLE_STOCK);
        sqLiteDatabase.execSQL(WarehouseManager.CREATE_TABLE_WAREHOUSE);
        sqLiteDatabase.execSQL(NotepadManager.CREATE_TABLE_NOTEAPAD);
        sqLiteDatabase.execSQL(ParameterManager.CREATE_TABLE_PARAMETER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        //upgrades the database
        onCreate(sqLiteDatabase);
    }
}
