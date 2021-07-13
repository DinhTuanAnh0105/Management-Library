package com.example.nhom1_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper  extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, "QuanLyThuVien.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table user(MaSV text primary key, password text)");
        sqLiteDatabase.execSQL("Create table DsSach(MaS text primary key, TenS text, TacGia text, Vitri text, Soluong text, NamXb text, Tinhtrang text)");
        sqLiteDatabase.execSQL("Create table DsNguoiMuon(MaSV text primary key, TenSV text, Lop text, Sdt text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists user");
        sqLiteDatabase.execSQL("drop table if exists DsSach");
    }
    // insert db user
    public boolean insertTK (String MaSV, String Password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaSV",MaSV);
        contentValues.put("PassWord",Password);
        long ins = db.insert("user", null, contentValues);
        if (ins==-1) return false;
        else return true;
    }
    //Check MaSV
    public boolean CheckMaSV(String MaSV){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where MaSV=?", new String[]{MaSV});
        if (cursor.getCount()>0) return false;
        else return true;
    }
    //Check MaSV
    /*public boolean CheckMaSinhVien(String MaSV){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from DsNguoiMuon where MaSV=?", new String[]{MaSV});
        if (cursor.getCount()>0) return true;
        else return false;
    }*/
    //check Login
    public  boolean CheckLogin(String MaSV, String Password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where MaSV=? and PassWord=?", new String[]{MaSV,Password});
        if (cursor.getCount()>0) return true;
        else return false;
    }
    //doimatkhau
    public  boolean doimatkhau(String MaSV, String NewPassword){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update user set PassWord = ? where MaSV=?", new String[]{NewPassword,MaSV});
        Cursor cursor = db.rawQuery("Select * from user where MaSV=? and PassWord = ?", new String[]{MaSV,NewPassword});
        if (cursor.getCount()>0) return true;
        else return false;
    }
    //check Sach
    /*public  boolean CheckSach(String MaS){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from DsSach where MaS=?", new String[]{MaS});
        if (cursor.getCount()>0) return true;
        else return false;
    }*/

    //Them thông tin sách
    public boolean insertSach(String MaS,String TenS, String TacGia, String Vitri, String Soluong, String NamXb, String Tinhtrang){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaS",MaS);
        contentValues.put("TenS",TenS);
        contentValues.put("TacGia",TacGia);
        contentValues.put("Vitri",Vitri);
        contentValues.put("Soluong",Soluong);
        contentValues.put("NamXb",NamXb);
        contentValues.put("Tinhtrang",Tinhtrang);
        long ins = db.insert("DsSach", null, contentValues);
        if (ins==-1) return false;
        else return true;
    }
    //get datasach
    public ArrayList getDataS(ArrayList<DsSachClass>dsSach){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from DsSach ", null);
        while (cursor.moveToNext()){
            String MaS = cursor.getString(0);
            String TenS = cursor.getString(1);
            String TenTG = cursor.getString(2);
            String ViTri = cursor.getString(3);
            String SoLuong = cursor.getString(4);
            String NamXb = cursor.getString(5);
            String TinhTrang = cursor.getString(6);
            dsSach.add(new DsSachClass(MaS, TenS, TenTG, ViTri,SoLuong, NamXb,TinhTrang));
        }
        return dsSach;
    }
    //Update Sach
    public boolean upDateSach(String MaS,String TenS, String TacGia, String Vitri, String Soluong, String NamXb, String Tinhtrang){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE DsSach SET TenS=?,TacGia=?,Vitri=?,Soluong=?,NamXb=?,Tinhtrang=? WHERE MaS =?", new String[]{TenS,TacGia,Vitri,Soluong,NamXb,Tinhtrang,MaS});
        Cursor cursor = db.rawQuery("Select * from DsSach where MaS=?", new String[]{MaS});
        if (cursor.getCount()>0) return true;
        else return false;
    }
    //Delete Sach
    public boolean DeleteSach(String MaS){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM DsSach WHERE MaS =?", new String[]{MaS});
        Cursor cursor = db.rawQuery("Select * from DsSach where MaS=?", new String[]{MaS});
        if (cursor.getCount()>0) return false;
        else return true;
    }
    //TimKiemsach
    public ArrayList Timkiemsach(ArrayList<DsSachClass>dsSach, String s){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from DsSach where TenS LIKE "+"'"+"%"+s+"%"+"'", null);
        while (cursor.moveToNext()){
            String MaS = cursor.getString(0);
            String TenS = cursor.getString(1);
            String TenTG = cursor.getString(2);
            String ViTri = cursor.getString(3);
            String SoLuong = cursor.getString(4);
            String NamXb = cursor.getString(5);
            String TinhTrang = cursor.getString(6);
            dsSach.add(new DsSachClass(MaS, TenS, TenTG, ViTri,SoLuong, NamXb,TinhTrang));
        }
        return dsSach;
    }
    //get dataNguoiMuon
    public ArrayList getDataNM(ArrayList<DsNguoiMuonClass>dsNguoiMuon){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from DsNguoiMuon ", null);
        while (cursor.moveToNext()){
            String MaSV = cursor.getString(0);
            String TenSV = cursor.getString(1);
            String Lop = cursor.getString(2);
            String Sdt = cursor.getString(3);
            dsNguoiMuon.add(new DsNguoiMuonClass(MaSV,TenSV,Lop,Sdt));
        }
        return dsNguoiMuon;
    }
    //get dataNguoiMuon
    public ArrayList TimKiemSV(ArrayList<DsNguoiMuonClass>dsNguoiMuon,String s){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from DsNguoiMuon where TenSV LIKE "+"'"+"%"+s+"%"+"'", null);
        while (cursor.moveToNext()){
            String MaSV = cursor.getString(0);
            String TenSV = cursor.getString(1);
            String Lop = cursor.getString(2);
            String Sdt = cursor.getString(3);
            dsNguoiMuon.add(new DsNguoiMuonClass(MaSV,TenSV,Lop,Sdt));
        }
        return dsNguoiMuon;
    }
    //Them SV
    public boolean insertNguoiMuon(String MaSV,String TenSV, String Lop, String Sdt){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaSV",MaSV);
        contentValues.put("TenSV",TenSV);
        contentValues.put("Lop",Lop);
        contentValues.put("Sdt",Sdt);
        long ins = db.insert("DsNguoiMuon", null, contentValues);
        if (ins==-1) return false;
        else return true;
    }
    //Update SV
    public boolean upDateSV(String MaSV,String TenSV, String Lop, String Sdt){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE DsNguoiMuon SET TenSV=?,Lop=?,Sdt=? WHERE MaSV =?", new String[]{TenSV,Lop,Sdt,MaSV});
        Cursor cursor = db.rawQuery("Select * from DsNguoiMuon where MaSV=?", new String[]{MaSV});
        if (cursor.getCount()>0) return true;
        else return false;
    }
    //Delete Sinh Viên
    public boolean DeleteSV(String MaSV){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM DsNguoiMuon WHERE MaSV =?", new String[]{MaSV});
        Cursor cursor = db.rawQuery("Select * from DsNguoiMuon where MaSV=?", new String[]{MaSV});
        if (cursor.getCount()>0) return false;
        else return true;
    }
}
//144 Order by TenSV
//96 Order by TenS