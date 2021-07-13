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

public class DangNhap extends AppCompatActivity {

    DatabaseHelper db;
    EditText etTenDN, etMatkhau;
    TextView tvDangnhap;
    Button btnDangky, btnDangnhap;
    ImageView imgAccount;

    public static final String etAddMasv  = "masingvien";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        db = new DatabaseHelper(this);
        getViews();
        btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangNhap.this, DangKy.class);
                startActivity(intent);
            }
        });
        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });
    }
    private void getViews() {
        etMatkhau = (EditText) findViewById(R.id.etMatkhau);
        etTenDN = (EditText) findViewById(R.id.etTenDN);
        tvDangnhap = (TextView) findViewById(R.id.tvDangnhap);
        btnDangky = (Button) findViewById(R.id.btnDangky);
        btnDangnhap = (Button) findViewById(R.id.btnDangnhap);
        imgAccount = (ImageView) findViewById(R.id.imgAccount);
    }
    private void Login(){
        String MaSV = etTenDN.getText().toString();
        String Matkhau = etMatkhau.getText().toString();
        Boolean checkLogin = db.CheckLogin(MaSV,Matkhau);
        if (checkLogin==true){
            Toast.makeText(getApplicationContext(), "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DangNhap.this, MainActivity.class);
            intent.putExtra(etAddMasv, MaSV);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Kiểm tra lại mã sinh viên hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
        }
    }
}