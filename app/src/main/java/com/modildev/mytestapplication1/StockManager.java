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

    public int deleteStock(int ID){
        String where = id + " = ?";
        String[] whereArgs = {ID+""};
        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public int editStock(int ID, String newtype, int newQuantity, int newWarehouseID){
        ContentValues values = new ContentValues();
        Stock s = getStock(ID);
        values.put(id, ID);

        if (newtype.equals(""))
            values.put(type, s.getType());
        else
            values.put(type, newtype);

        if (newQuantity == -1)
            values.put(quantity, s.getQuantity());
        else
            values.put(quantity, newQuantity);

        if (newWarehouseID == -1)
            values.put(warehouseID, s.getWarehouseID());
        else
            values.put(warehouseID, newWarehouseID);

        String where = id + " = ?";
        String[] whereArgs = {s.getId()+""};
        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public Stock getStock(int ID){
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + id + "=?", new String[]{Integer.toString(ID)});
        if (c.moveToFirst()){
            //int Id = c.getInt(c.getColumnIndex(id));
            String Type = c.getString(c.getColumnIndex(type));
            int Quantity = c.getInt(c.getColumnIndex(quantity));
            int WarehouseID = c.getInt(c.getColumnIndex(quantity));
            Stock s = new Stock(ID, Type,WarehouseID, Quantity);
            return s;
        }
        return null;
    }

    public ArrayList<Stock> searchStock(String keyword){
        ArrayList<Stock> results = new ArrayList<Stock>();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + type + " LIKE ?", new String[]{"%"+keyword+"%"});
        if (c.moveToNext()){
            int Id = c.getInt(c.getColumnIndex(id));
            String Type = c.getString(c.getColumnIndex(type));
            int Quantity = c.getInt(c.getColumnIndex(quantity));
            int WarehouseID = c.getInt(c.getColumnIndex(quantity));
            Stock s = new Stock(Id, Type,WarehouseID, Quantity);
            results.add(s);
        }
        return results;
    }

    public ArrayList<Stock> getAll(int WarehouseID){
        ArrayList<Stock> results = new ArrayList<Stock>();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + warehouseID + "= ?", new String[]{Integer.toString(WarehouseID)});
        while (c.moveToNext()){
            int Id = c.getInt(c.getColumnIndex(id));
            String Type = c.getString(c.getColumnIndex(type));
            int Quantity = c.getInt(c.getColumnIndex(quantity));
            //int WarehouseID = c.getInt(c.getColumnIndex(quantity));
            Stock s = new Stock(Id, Type, WarehouseID, Quantity);
            results.add(s);
        }
        return results;
    }

    public Cursor getStocks(){
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

}
