package com.example.myapplication3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.ContentHandler;
import java.util.ArrayList;
import java.util.List;

public class Dao {

    private final DB helper;

    public Dao(Context context){
        helper = new DB(context);
        //helper.getWritableDatabase();
    }
    public void insert(int id, String name, String time, boolean finished){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "insert into items(id, name, time, finished) values(?, ?, ?, ?)";
        db.execSQL(sql, new Object[]{id, name, time, finished});
        db.close();
    }
    public void delete(int id){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "delete from items where id = " + id;
        db.execSQL(sql);
        db.close();
    }
    public void update_true(int id){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "update items set finished = true where id = " + id;
        db.execSQL(sql);
        db.close();
    }
    public void update_false(int id){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "update items set finished = false where id = " + id;
        db.execSQL(sql);
        db.close();
    }
    public List<It> query(){
        List<It> itList = new ArrayList<>();
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "select * from items";
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            It it = new It(cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("time")), Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex("checked"))));
            itList.add(it);
        }
        cursor.close();
        db.close();
        return  itList;
    }
    public int get_num(){
        int count = 0;
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "select * from items";
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            count++;
        }
        cursor.close();
        db.close();
        return  count;
    }
}
