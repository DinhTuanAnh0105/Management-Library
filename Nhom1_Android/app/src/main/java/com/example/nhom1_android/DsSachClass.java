package com.example.nhom1_android;

import java.io.Serializable;

public class DsSachClass implements Serializable {
    private String MaS;
    private String TenS;
    private String TenTG;
    private String ViTri;
    private String sl;
    private String Namxb;
    private String tinhtrang;

    public DsSachClass(String maS, String tenS, String tenTG, String viTri, String sl, String namxb, String tinhtrang) {
        MaS = maS;
        TenS = tenS;
        TenTG = tenTG;
        ViTri = viTri;
        this.sl = sl;
        Namxb = namxb;
        this.tinhtrang = tinhtrang;
    }

    public String getMaS() {
        return MaS;
    }

    public String getTenS() {
        return TenS;
    }

    public String getTenTG() {
        return TenTG;
    }

    public String getViTri() {
        return ViTri;
    }

    public String getSl() {
        return sl;
    }

    public String getNamxb() {
        return Namxb;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setMaS(String maS) {
        MaS = maS;
    }

    public void setTenS(String tenS) {
        TenS = tenS;
    }

    public void setTenTG(String tenTG) {
        TenTG = tenTG;
    }

    public void setViTri(String viTri) {
        ViTri = viTri;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    public void setNamxb(String namxb) {
        Namxb = namxb;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public DsSachClass() {
    }

    @Override
    public String toString() {
        return "DsSachClass{" +
                "MaS='" + MaS + '\'' +
                ", TenS='" + TenS + '\'' +
                ", TenTG='" + TenTG + '\'' +
                ", ViTri='" + ViTri + '\'' +
                ", sl='" + sl + '\'' +
                ", Namxb='" + Namxb + '\'' +
                ", tinhtrang='" + tinhtrang + '\'' +
                '}';
    }
}
