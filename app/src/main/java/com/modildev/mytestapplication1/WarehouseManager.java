package com.modildev.mytestapplication1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

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
        values.put(address, w.getaddress());
        values.put(name, w.getName());
        return db.insert(TABLE_NAME, null, values);
    }

    public int deleteWarehouse(int ID){
        String where = id + " = ?";
        String[] whereArgs = {ID+""};
        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public int editWarehouse(int ID, String newAddress, String newName){
        Warehouse w = getWarehouse(ID);
        ContentValues values = new ContentValues();
        values.put(id, ID);

        if (newAddress.equals(""))
            values.put(address, w.getaddress());
        else
            values.put(address, newAddress);

        if (newName.equals(""))
            values.put(name, w.getName());
        else
            values.put(name, newName);

        String where = id + " = ?";
        String[] whereArgs = {w.getWarehouseID()+""};
        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public Warehouse getWarehouse(int ID){
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + id + "=?", new String[]{Integer.toString(ID)});
        if (c.moveToFirst()){
            int Id = c.getInt(c.getColumnIndex(id));
            String Address = c.getString(c.getColumnIndex(address));
            String Name = c.getString(c.getColumnIndex(name));
            Warehouse w = new Warehouse(ID, Address, Name);
            return w;
        }
        return null;
    }

    public ArrayList<Warehouse> select(String keyword){
        ArrayList<Warehouse> results = new ArrayList<Warehouse>();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + address + " LIKE ? " + " OR " + name + " LIKE ? ", new String[]{"%"+keyword+"%", "%"+keyword+"%"});
        while (c.moveToNext()){
            int Id = c.getInt(c.getColumnIndex(id));
            String Address = c.getString(c.getColumnIndex(address));
            String Name = c.getString(c.getColumnIndex(name));
            Warehouse w = new Warehouse(Id, Address, Name);
            results.add(w);
        }
        return results;
    }

    public Cursor getWarehouses(){
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
}
