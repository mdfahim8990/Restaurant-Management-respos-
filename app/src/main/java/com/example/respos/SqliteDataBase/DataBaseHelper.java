package com.example.respos.SqliteDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import androidx.annotation.Nullable;


public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    public String Id, Restaurant_name, Phone_number, Api_key, Api_secet, Kitchen_id, Api_endpoint, Address;


    public DataBaseHelper(@Nullable Context context) {
        super(context, "myDatabase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists mytable (id integer primary key autoincrement , Restaurant_name text , Phone_number  text, Api_key text,Api_secret text,Kitchen_id text,Api_endpoint text , Address text) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists mytable");
        onCreate(db);
    }

    public void insertData(Data data) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Restaurant_name", data.getRestaurant_name());
        contentValues.put("Phone_number", data.getPhone_number());
        contentValues.put("Api_key", data.getApi_key());
        contentValues.put("Api_secret", data.getApi_secret());
        contentValues.put("Kitchen_id", data.getKitchen_id());
        contentValues.put("Api_endpoint", data.getApi_endpoint());
        contentValues.put("Address", data.getAddress());
        long mytable = sqLiteDatabase.insert("mytable", null, contentValues);

        Log.e(TAG, "insertData :" + mytable);

    }

    public void fetchAllData() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from mytable", null, null);
        while (cursor.moveToNext()) {
            Id = cursor.getString(0);
            Restaurant_name = cursor.getString(1);
            Phone_number = cursor.getString(2);
            Api_key = cursor.getString(3);
            Api_secet = cursor.getString(4);
            Kitchen_id = cursor.getString(5);
            Api_endpoint = cursor.getString(6);
            Address = cursor.getString(7);
            Log.e(TAG, "Name: " + cursor.getString(1) + "\nPhone_number: " + cursor.getString(2) + "\nApi_key:" + cursor.getString(3));
        }
        cursor.close();
    }

    public int GetId(Data data) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select id from notepadData where notepad = '" + data + "'", null);
        return cursor.getColumnIndex("id");
    }

    public void UpdateData(Data data,String id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Restaurant_name", data.getRestaurant_name());
        contentValues.put("Phone_number", data.getPhone_number());
        contentValues.put("Api_key", data.getApi_key());
        contentValues.put("Api_secret", data.getApi_secret());
        contentValues.put("Kitchen_id", data.getKitchen_id());
        contentValues.put("Api_endpoint", data.getApi_endpoint());
        contentValues.put("Address", data.getAddress());
        long mytable = sqLiteDatabase.update("mytable", contentValues, "id = ? ",  new String[]{id});

        Log.e(TAG, "UpdateData :" + mytable);

    }

    public void deleteData(Data data) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int mytable = sqLiteDatabase.delete("mytable", "Restaurant_name = ' " + data.getRestaurant_name() + "'", null);
        Log.e(TAG, "DeleteData :" + mytable);
    }


}
