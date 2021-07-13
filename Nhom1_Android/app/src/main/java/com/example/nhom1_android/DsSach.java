package com.example.nhom1_android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DsSach extends AppCompatActivity {

    ListView lvSach;
    DatabaseHelper db;
    DsSachAdapter dsSachAdapter;
    ArrayList<DsSachClass> arrayDsSach;
    ArrayList<DsSachClass> arrayDsSach2;
    //Button btnMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_sach);
        getview();
        db = new DatabaseHelper(this);
        arrayDsSach = new ArrayList<>();
        dsSachAdapter = new DsSachAdapter(this,arrayDsSach);
        lvSach.setAdapter(dsSachAdapter);
        Log.d("check", "showInfoSach: "+arrayDsSach);
        getDataS();
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.add_Sach);
        floatingActionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                themsach();
            }
        });


        //btnMain = (Button) findViewById(R.id.btnMain);
        //btnMain.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        Intent intent = new Intent(DsSach.this,MainActivity.class);
         //       startActivity(intent);
        //    }
       // });

    }
    private void getview(){
        lvSach = (ListView) findViewById(R.id.lvSach);
    }
    private void themsach(){
        Intent intent = new Intent(DsSach.this, ThemSach.class);
        startActivity(intent);
    }
    public void getDataS(){
        arrayDsSach.clear();
        arrayDsSach = db.getDataS(arrayDsSach);

        dsSachAdapter.notifyDataSetChanged();
    }

    public void dialogUpdate(final String MaSach, String TenSach, String TG, String ViTri, String SoLuong, String NamXb, String TinhTrang){
        AlertDialog.Builder alert = new AlertDialog.Builder(DsSach.this);
        View mViewEditSach = (View) getLayoutInflater().inflate(R.layout.edit_sach,null);
        alert.setView(mViewEditSach);
        final AlertDialog alertDialog = alert.create();
        alertDialog.setCanceledOnTouchOutside(false);
        Log.d("check", "show: "+TinhTrang);
        final EditText etTenSach = (EditText) mViewEditSach.findViewById(R.id.etEditTenS);
        final EditText etTG = (EditText) mViewEditSach.findViewById(R.id.etEditTG);
        final EditText etViTri = (EditText) mViewEditSach.findViewById(R.id.etEditViTri);
        final EditText etSoLuong = (EditText) mViewEditSach.findViewById(R.id.etEditSoLuong);
        final EditText etNamXb = (EditText) mViewEditSach.findViewById(R.id.etEditNamXb);
        final EditText etTinhtrang = (EditText) mViewEditSach.findViewById(R.id.etEditTinhTrang);
        Button btnEditSach = (Button) mViewEditSach.findViewById(R.id.btnEditSach);
        Button btnCancelEditS = (Button) mViewEditSach.findViewById(R.id.btnCancelEditS);
        etTenSach.setText(TenSach);
        etTG.setText(TG);
        etViTri.setText(ViTri);
        etSoLuong.setText(SoLuong);
        etNamXb.setText(NamXb);
        etTinhtrang.setText(TinhTrang);
        btnCancelEditS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        btnEditSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("check", "showss: "+etTenSach.getText().toString());
                String TenSach = etTenSach.getText().toString();
                String TG = etTG.getText().toString();
                String ViTri = etViTri.getText().toString();
                String SoLuong = etSoLuong.getText().toString();
                String NamXb = etNamXb.getText().toString();
                String Tinhtrang = etTinhtrang.getText().toString();
                Boolean upDateSach = db.upDateSach(MaSach,TenSach,TG,ViTri,SoLuong,NamXb,Tinhtrang);

                if (upDateSach == true){
                    //Log.d("check", "showss: "+etTenSach.getText().toString());
                    Toast.makeText(getApplicationContext(), "Cập nhật thông tin thành công!", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                    getDataS();
                }
                else {
                    alertDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Cập nhật thông tin thất bại!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alertDialog.show();
    }

    public void dialogDelete(final String MaSach){
        final AlertDialog.Builder alert = new AlertDialog.Builder(DsSach.this);
        View mViewDeleteSach = (View) getLayoutInflater().inflate(R.layout.dialog_xoa,null);
        alert.setView(mViewDeleteSach);
        final AlertDialog alertDialog = alert.create();
        alertDialog.setCanceledOnTouchOutside(false);
        Button btnHuy = (Button) mViewDeleteSach.findViewById(R.id.btnHuy);
        Button btnXoa = (Button) mViewDeleteSach.findViewById(R.id.btnXoa);
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean DeleteSach = db.DeleteSach(MaSach);
                if (DeleteSach == true){Toast.makeText(getApplicationContext(), "Xóa thông tin thành công!", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                    getDataS();
                }
                else {
                    alertDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Xóa thông tin thất bại!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alertDialog.show();
    }
    public void dialogChiTiet(final String MaSach, String TenSach, String TG, String ViTri, String SoLuong, String NamXb, String TinhTrang){
        AlertDialog.Builder alert = new AlertDialog.Builder(DsSach.this);
        View mViewChiTietSach = (View) getLayoutInflater().inflate(R.layout.chi_tiet_sach,null);
        alert.setView(mViewChiTietSach);
        final AlertDialog alertDialog = alert.create();
        alertDialog.setCanceledOnTouchOutside(false);
        final TextView etMaSach = (TextView) mViewChiTietSach.findViewById(R.id.tvMaS2);
        final TextView etTenSach = (TextView) mViewChiTietSach.findViewById(R.id.tvTenS2);
        final TextView etTG = (TextView) mViewChiTietSach.findViewById(R.id.tvTacGia2);
        final TextView etViTri = (TextView) mViewChiTietSach.findViewById(R.id.tvViTri2);
        final TextView etSoLuong = (TextView) mViewChiTietSach.findViewById(R.id.tvSoLuong2);
        final TextView etNamXb = (TextView) mViewChiTietSach.findViewById(R.id.tvNamXB2);
        final TextView etTinhtrang = (TextView) mViewChiTietSach.findViewById(R.id.tvTinhTrang2);
        Button btnThoat = (Button) mViewChiTietSach.findViewById(R.id.btnThoat);
        etMaSach.setText(MaSach);
        etTenSach.setText(TenSach);
        etTG.setText(TG);
        etViTri.setText(ViTri);
        etSoLuong.setText(SoLuong);
        etNamXb.setText(NamXb);
        etTinhtrang.setText(TinhTrang);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_app,menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.menuSearch).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                arrayDsSach = db.getDataS(arrayDsSach);
                Log.d("TAG", "showsss: "+arrayDsSach);
                    /*arrayDsSach.clear();
                    arrayDsSach = db.Timkiemsach(arrayDsSach,s);
                    dsSachAdapter.notifyDataSetChanged();*/
               /* return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                arrayDsSach.clear();
                arrayDsSach = db.Timkiemsach(arrayDsSach,s);
                dsSachAdapter.notifyDataSetChanged();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }*/
}