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

public class ThemSach extends AppCompatActivity {

    DatabaseHelper db;
    TextView tvThemSach;
    EditText etMaSach, etTenTG,etViTri,etSoLuong,etTinhTrang,etNamxb,etTenS;
    Button btnThem, btnHuy;
    ImageView imgSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sach);

        db=new DatabaseHelper(this);
        getView();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSach();
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThemSach.this, DsSach.class);
                startActivity(intent);
            }
        });
    }
    private void getView() {
        etMaSach = (EditText) findViewById(R.id.etMasach);
        etTenTG = (EditText) findViewById(R.id.etTenTG);
        etViTri = (EditText) findViewById(R.id.etVitri);
        etSoLuong = (EditText) findViewById(R.id.etSoluong);
        etTenS = (EditText) findViewById(R.id.ettensach);
        etNamxb = (EditText) findViewById(R.id.etNamXB);
        etTinhTrang = (EditText) findViewById(R.id.etTinhtrang);
        tvThemSach = (TextView) findViewById(R.id.tvThemSach);
        btnThem = (Button) findViewById(R.id.btnThem);
        btnHuy = (Button) findViewById(R.id.btnHuy);
        imgSach=(ImageView) findViewById(R.id.imgSach);
    }
    private void addSach() {
        String MaS = etMaSach.getText().toString();
        String TenS = etTenS.getText().toString();
        String TenTG = etTenTG.getText().toString();
        String Vitri = etViTri.getText().toString();
        String SoLuong =etSoLuong.getText().toString();
        String Namxb= etNamxb.getText().toString();
        String TinhTrang= etTinhTrang.getText().toString();
        //Boolean checkSach = db.CheckSach(MaS);
        //if (checkSach==false){
            Boolean insertSach = db.insertSach(MaS,TenS,TenTG,Vitri,SoLuong,Namxb,TinhTrang);
            //if (insertSach == true){
                Toast.makeText(getApplicationContext(), "Lưu thông tin thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ThemSach.this, DsSach.class);
                startActivity(intent);
            }
            //else {
                //Toast.makeText(getApplicationContext(), "Lưu thông tin thất bại!", Toast.LENGTH_SHORT).show();
            //}
        //}
        //else {
          //Toast.makeText(getApplicationContext(), "Sách đã tồn tại", Toast.LENGTH_SHORT).show();
        //}

    //}
    private void deleteSach(){

    }
}