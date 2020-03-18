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
            + id + " INTEGER primary key AUTOINCREMENT, "
            + type + " TEXT, "
            + quantity + " INTEGER, "
            + warehouseID + " INTEGER);";
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

    public long addStock(Stock s){
        ContentValues values = new ContentValues();
        //values.put(id, s.getId());
        values.put(type, s.getType());
        values.put(quantity, s.getQuantity());
        values.put(warehouseID, s.getWarehouseID());
        return db.insert(TABLE_NAME, null, values);
    }

    public int deleteStock(Stock s){
        String where = id + " = ?";
        String[] whereArgs = {s.getId()+""};
        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public int editStock(Stock s){
        ContentValues values = new ContentValues();
        values.put(id, s.getId());
        values.put(type, s.getType());
        values.put(quantity, s.getQuantity());
        values.put(warehouseID, s.getWarehouseID());
        String where = id + " ?";
        String[] whereArgs = {s.getId()+""};
        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public Stock getStock(int ID){
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + id + "=?", new String[]{Integer.toString(ID)});
        if (c.moveToFirst()){
            int Id = c.getInt(c.getColumnIndex(id));
            String Type = c.getString(c.getColumnIndex(type));
            int Quantity = c.getInt(c.getColumnIndex(quantity));
            int WarehouseID = c.getInt(c.getColumnIndex(quantity));
            Stock s = new Stock(ID, Type,WarehouseID, Quantity);
            return s;
        }
        return null;
    }

    public Cursor getStocks(){
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

}
