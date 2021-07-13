package com.example.nhom1_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DoiMatKhau extends AppCompatActivity {

    DatabaseHelper db;
    Button btnXacNhan;
    EditText etMatKhauCu;
    EditText etMatKhauMoi;
    EditText etXacNhanMK;
    String tkDangNhap;
    //Button btnMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_mat_khau);
        getView();
        db = new DatabaseHelper(this);
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doiMatKhau();
            }
        });
        Intent intent = getIntent();
        tkDangNhap = intent.getStringExtra(MainActivity.etAddMasv2);

       
        //btnMain = (Button) findViewById(R.id.btnMain);
        //btnMain.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
              //  Intent intent = new Intent(DoiMatKhau.this,MainActivity.class);
             //   startActivity(intent);
           // }
       // });
    }


    private void getView() {
        etMatKhauCu = (EditText)findViewById(R.id.etMKcu);
        etMatKhauMoi= (EditText)findViewById(R.id.etMKmoi);
        etXacNhanMK = (EditText)findViewById(R.id.etXacnhan);
        btnXacNhan= (Button)findViewById(R.id.btnAccept);
    }
    private void doiMatKhau(){
        //Toast.makeText(DoiMatKhau.this, "Hãy nhập đầy đủ thông tin !"+tkDangNhap, Toast.LENGTH_LONG).show();
        String MatKhauCu = etMatKhauCu.getText().toString();
        String MatKhauMoi = etMatKhauMoi.getText().toString();
        String XacNhanMK = etXacNhanMK.getText().toString();
        if(MatKhauMoi.equals(XacNhanMK)){
            Toast.makeText(DoiMatKhau.this, "Mật khẩu không trùng khớp !", Toast.LENGTH_LONG).show();
        }
        if(MatKhauMoi.equals("")||MatKhauCu.equals("")||XacNhanMK.equals("")){
            Toast.makeText(DoiMatKhau.this, "Hãy nhập đầy đủ thông tin !", Toast.LENGTH_LONG).show();
        }
        Boolean doimatkhau = db.doimatkhau(tkDangNhap,MatKhauMoi);
        if(doimatkhau==true){
            Toast.makeText(DoiMatKhau.this, "Đổi mật khẩu thành công !", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(DoiMatKhau.this, MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(DoiMatKhau.this, "Đổi mật khẩu thất bại !", Toast.LENGTH_LONG).show();
        }
    }
}