package com.example.ph19466_duanmau.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {
    public Dbhelper(Context context) {
        super(context, "DBQUANLYSACH", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table THUTHU(matt text primary key , hoten text , matkhau text)");
        db.execSQL("create table THANHVIEN(matv integer primary key autoincrement , hoten text , namsinh text)");
        db.execSQL("create table LOAISACH (maloai integer primary key autoincrement, tenoai text )");
        db.execSQL("create table SACH(masach integer primary key autoincrement, tensach text , giathue integer , maloai integer references " +
                "LOAISACH(maloai))");
        db.execSQL("create table PHIEUMUON(mapm integer primary key autoincrement , matv integer references THANHVIEN(matv) , " +
                "matt text references THUTHU(matt) , masach integer references SACH(masach) , ngay text , trasach integer , tienthue integer)");
        // data mẫu
        db.execSQL("INSERT INTO LOAISACH VALUES (1, 'Thiếu nhi'),(2,'Tình cảm'),(3, 'Giáo khoa')");
        db.execSQL("INSERT INTO SACH VALUES (1, 'Hãy đợi đấy', 2500, 1), (2, 'Thằng cuội', 1000, 1), (3, 'Lập trình Android', 2000, 3)");
        db.execSQL("INSERT INTO THUTHU VALUES ('thuthu01','Nguyễn Văn Anh','abc123'),('thuthu02','Trần Văn Hùng','123abc')");
        db.execSQL("INSERT INTO THANHVIEN VALUES (1,'Cao Thu Trang','2000'),(2,'Trần Mỹ Kim','2000')");
        //trả sách: 1: đã trả - 0: chưa trả
        db.execSQL("INSERT INTO PHIEUMUON VALUES (1,1,'thuthu01', 1, '19/03/2022', 1, 2500),(2,1,'thuthu01', 3, '19/03/2022', 0, 2000),(3,2,'thuthu02', 1, '19/03/2022', 1, 2000)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1 ){
            db.execSQL("drop table if exists THUTHU");
            db.execSQL("drop table if exists THANHVIEN");
            db.execSQL("drop table if exists LOAISACH");
            db.execSQL("drop table if exists SACH");
            db.execSQL("drop table if exists PHIEUMUON");
            onCreate(db);
        }

    }
}
