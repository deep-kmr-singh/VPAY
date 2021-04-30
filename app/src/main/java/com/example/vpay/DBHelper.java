package com.example.vpay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "VPAY1.db";

    //public static final String users = "create table users (username TEXT primary key, password TEXT)";
    //public static final String cards = "create table cards (card_no TEXT primary key, expiry_month TEXT, expiry_year TEXT, cvv_no TEXT, customer_name TEXT, mobile_no TEXT)";

    public DBHelper(Context context) {
        super(context, "VPAY1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        //MyDB.execSQL("create table cards (card_no TEXT primary key, expiry_month TEXT, expiry_year TEXT, cvv_no TEXT, customer_name TEXT, mobile_no TEXT)");

        //MyDB.execSQL(users);
        //MyDB.execSQL(cards);
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        //MyDB.execSQL("drop Table if exists users");

        MyDB.execSQL("drop table if exists users");
        //MyDB.execSQL("drop table if exists cards");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if (result == 1)
            return true;
        else
            return false;
    }

    public Boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword (String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    /*public Boolean checkcard(String card_no){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from cards where card_no = ?", new String[] {card_no});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean insertCard(String card_no, String expiry_month, String expiry_year, String cvv_no, String customer_name, String mobile_no){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("card_no", card_no);
        contentValues.put("expiry_month", expiry_month);
        contentValues.put("expiry_year", expiry_year);
        contentValues.put("cvv_no", cvv_no);
        contentValues.put("customer_name", customer_name);
        contentValues.put("mobile_no", mobile_no);
        long result = MyDB.insert("cards", null, contentValues);
        if (result == 1)
            return true;
        else
            return false;
    }

    public Cursor readalldata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from cards";
        Cursor cursor = db.rawQuery(qry,null);
        return  cursor;
    }*/
}
