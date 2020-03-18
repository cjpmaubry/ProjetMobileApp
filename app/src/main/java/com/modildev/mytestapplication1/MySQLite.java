package com.modildev.mytestapplication1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLite extends SQLiteOpenHelper {
    private static final String DBName = "Pico.db";
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
        // Création de la base de données
        // on exécute ici les requêtes de création des tables
        sqLiteDatabase.execSQL(StockManager.CREATE_TABLE_STOCK);
        sqLiteDatabase.execSQL(WarehouseManager.CREATE_TABLE_WAREHOUSE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        // Mise à jour de la base de données
        // méthode appelée sur incrémentation de DATABASE_VERSION
        // on peut faire ce qu'on veut ici, comme recréer la base :
        onCreate(sqLiteDatabase);
    }
}
