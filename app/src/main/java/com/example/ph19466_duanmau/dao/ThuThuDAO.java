package com.example.ph19466_duanmau.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ph19466_duanmau.database.Dbhelper;

public class ThuThuDAO {
    Dbhelper dbhelper;
    public ThuThuDAO (Context context){
        dbhelper = new Dbhelper(context);
    }
    // hàm dăng nhập
    public boolean checkDangNhap(String matt, String matkhau){
        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
        Cursor cursor  = sqLiteDatabase.rawQuery("select * from THUTHU where matt = ? and matkhau = ? ",new String[]{matt,matkhau});
        if (cursor.getCount()!=0){
            return true;
        }
        return false;
    }

}
