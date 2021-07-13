package com.example.nhom1_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ThemNguoiMuon extends AppCompatActivity {
    DatabaseHelper db;
    EditText etMaSV, etTenSV,etLop,etSdt;
    Button btnThemSV, btnHuySV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nguoi_muon);
        db=new DatabaseHelper(this);
        getView();
        btnThemSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNguoiMuon();
            }
        });
    }
    private void getView(){
        etMaSV = (EditText) findViewById(R.id.etMaSV);
        etTenSV = (EditText) findViewById(R.id.etTenSV);
        etLop = (EditText) findViewById(R.id.etLop);
        etSdt = (EditText) findViewById(R.id.etSDT);
        btnThemSV = (Button) findViewById(R.id.btnThemSV);
        btnHuySV = (Button) findViewById(R.id.btnHuySV);
    }
    private void addNguoiMuon() {
        String MaSV = etMaSV.getText().toString();
        String TenSV = etTenSV.getText().toString();
        String Lop = etLop.getText().toString();
        String Sdt = etSdt.getText().toString();
        //Boolean CheckMaSV = db.CheckMaSinhVien(MaSV);
        //if (CheckMaSV==false){
            Boolean insertNguoiMuon = db.insertNguoiMuon(MaSV,TenSV,Lop,Sdt);
            //if (insertNguoiMuon == true){
                Toast.makeText(getApplicationContext(), "Lưu thông tin thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ThemNguoiMuon.this, DsNguoiMuon.class);
                startActivity(intent);
            //}
           // else {
            //    Toast.makeText(getApplicationContext(), "Lưu thông tin thất bại!", Toast.LENGTH_SHORT).show();
            //}
        //}
       // else {
           // Toast.makeText(getApplicationContext(), "Sinh viên đã tồn tại", Toast.LENGTH_SHORT).show();
        //}

    }
}