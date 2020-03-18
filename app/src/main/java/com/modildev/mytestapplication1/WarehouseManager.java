package com.modildev.mytestapplication1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class WarehouseManager {
    private static final String TABLE_NAME = "warehouses";
    public static final String id = "id";
    public static final String address = "address";
    public static final String name = "name";
    public static final String CREATE_TABLE_WAREHOUSE = "CREATE TABLE "
            + TABLE_NAME + " ("
            + id + " INTEGER primary key AUTOINCREMENT, "
            + address + " TEXT, "
            + name + " TEXT);";
    private SQLiteDatabase db;
    private MySQLite myBase;

    public WarehouseManager(Context context){
        myBase = MySQLite.getInstance(context);
    }

    public void open(){
        db = myBase.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public long addWarehouse(Warehouse w){
        ContentValues values = new ContentValues();
        //values.put(id, w.getWarehouseID());
        values.put(address, w.getAdress());
        values.put(name, w.getName());
        return db.insert(TABLE_NAME, null, values);
    }

    public int deleteWarehouse(Warehouse w){
        String where = id + " = ?";
        String[] whereArgs = {w.getWarehouseID()+""};
        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public int editWarehouse(Warehouse w){
        ContentValues values = new ContentValues();
        values.put(id, w.getWarehouseID());
        values.put(address, w.getAdress());
        values.put(name, w.getName());
        String where = id + " ?";
        String[] whereArgs = {w.getWarehouseID()+""};
        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public Warehouse getWarehouse(int ID){
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + id + "=?", new String[]{Integer.toString(ID)});
        if (c.moveToFirst()){
            int Id = c.getInt(c.getColumnIndex(id));
            String Adress = c.getString(c.getColumnIndex(address));
            String Name = c.getString(c.getColumnIndex(name));
            Warehouse w = new Warehouse(ID, Adress, Name);
            return w;
        }
        return null;
    }

    public Cursor getWarehouses(){
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
}
