package com.example.vpay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbmanager extends SQLiteOpenHelper
{
   private static final String dbname="VPAY2";

    public dbmanager(@Nullable Context context)
    {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
       String qry="create table cards ( id integer primary key autoincrement, card_no text, expiry_month text, expiry_year text, cvv_no text, amount text, customer_name text, mobile_no text)";
       sqLiteDatabase.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
      String qry="DROP TABLE IF EXISTS cards";
      sqLiteDatabase.execSQL(qry);
      onCreate(sqLiteDatabase);
    }

    public String addrecord(String card_no, String expiry_month, String expiry_year, String cvv_no, String amount, String customer_name, String mobile_no)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("card_no",card_no);
        cv.put("expiry_month",expiry_month);
        cv.put("expiry_year",expiry_year);
        cv.put("cvv_no",cvv_no);
        cv.put("amount",amount);
        cv.put("customer_name",customer_name);
        cv.put("mobile_no",mobile_no);
        float res=db.insert("cards",null,cv);

        if(res==-1)
             return "Card Creation Failed";
        else
             return  "Card Created Successfully";

    }

    public Cursor readalldata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from cards order by id desc";
        Cursor cursor=db.rawQuery(qry,null);
        return  cursor;
    }
}
