package com.example.nhom1_android;

import java.io.Serializable;

public class DsNguoiMuonClass implements Serializable {
    private String MaSv;
    private String TenSv;
    private String Lop;
    private String Sdt;

    public DsNguoiMuonClass() {
    }

    public DsNguoiMuonClass(String maSv, String tenSv, String lop, String sdt) {
        MaSv = maSv;
        TenSv = tenSv;
        Lop = lop;
        Sdt = sdt;
    }

    public DsNguoiMuonClass(String maS, String tenS, String tenTG, String viTri, String sl, String namxb, String tinhtrang) {
    }

    public String getMaSv() {
        return MaSv;
    }

    public void setMaSv(String maSv) {
        MaSv = maSv;
    }

    public String getTenSv() {
        return TenSv;
    }

    public void setTenSv(String tenSv) {
        TenSv = tenSv;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String lop) {
        Lop = lop;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    @Override
    public String toString() {
        return "DsNguoiMuonClass{" +
                "MaSv='" + MaSv + '\'' +
                ", TenSv='" + TenSv + '\'' +
                ", Lop='" + Lop + '\'' +
                ", Sdt='" + Sdt + '\'' +
                '}';
    }
}
