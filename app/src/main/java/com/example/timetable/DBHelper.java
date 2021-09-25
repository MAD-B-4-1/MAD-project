package com.example.timetable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME= "login.db";

    public DBHelper( Context context)  {
        super(context, "login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create table users(username TEXT primary key, password TEXT,name TEXT,mail TEXT,education TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
       MyDB.execSQL("drop table if exists users");

    }
    public boolean insertData (String username,String password,String name,String mail,String education){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("name",name);
        contentValues.put("mail",mail);
        contentValues.put("educationQualification",education);
        long result= MyDB.insert("users",null,contentValues);
        if (result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where username=?",new String[] {username} );
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username,String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where username=? and password=?",new String[] {username,password} );
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Cursor  getdata() {
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from  users",null);
        return cursor;

    }

    public boolean updateData (String name,String mail,String education) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("mail", mail);
        contentValues.put("educationQualification", education);
        Cursor cursor = MyDB.rawQuery("select * from users where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = MyDB.update("users", contentValues, "name=/", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
