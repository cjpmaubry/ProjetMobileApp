package com.modildev.mytestapplication1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotepadManager {
    private static final String TABLE_NAME = "Notepad";
    public static final String id = "id";
    public static final String comment = "comment";
    public static final String CREATE_TABLE_NOTEAPAD = "CREATE TABLE "
            + TABLE_NAME + " ("
            + id + " INTEGER primary key AUTOINCREMENT, "
            + comment + " TEXT)";
    private SQLiteDatabase db;
    private MySQLite myBase;

    public NotepadManager(Context context){
        myBase = MySQLite.getInstance(context);
    }

    public void open(){
        db = myBase.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public long addComment(Notepad n)
    {
        ContentValues values = new ContentValues();
        //values.put(id, s.getId());
        values.put(comment, n.getComment());
        return db.insert(TABLE_NAME, null, values);
    }

    public int deleteComment(int ID){
        String where = id + " = ?";
        String[] whereArgs = {ID+""};
        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public int editComment(int ID, String newComment){
        ContentValues values = new ContentValues();
        Notepad n = getComment(ID);
        values.put(id, ID);

        if (newComment.equals(""))
            values.put(comment, n.getComment());
        else
            values.put(comment, newComment);

        String where = id + " = ?";
        String[] whereArgs = {n.getId()+""};
        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public Notepad getComment(int ID){
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + id + "=?", new String[]{Integer.toString(ID)});
        if (c.moveToFirst()){
            //int Id = c.getInt(c.getColumnIndex(id));
            String Comment = c.getString(c.getColumnIndex(comment));

            Notepad n = new Notepad(ID,Comment);
            return n;
        }
        return null;
    }

    public ArrayList<Notepad> getAll(){
        ArrayList<Notepad> noteList = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        while (c.moveToNext()){
            int Id = c.getInt(c.getColumnIndex(id));
            String Comment = c.getString(c.getColumnIndex(comment));
            Notepad n = new Notepad(Id, Comment);
            noteList.add(n);
        }
        return noteList;
    }

}
