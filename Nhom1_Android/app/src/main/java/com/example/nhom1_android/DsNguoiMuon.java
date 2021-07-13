package com.example.nhom1_android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DsNguoiMuon extends AppCompatActivity {

    ListView lvNguoiMuon;
    DatabaseHelper db;
    DsNguoiMuonAdapter dsNguoiMuonAdapter;
    ArrayList<DsNguoiMuonClass> arrayDsNguoiMuon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_nguoi_muon);
        getview();
        db = new DatabaseHelper(this);
        arrayDsNguoiMuon = new ArrayList<>();
        dsNguoiMuonAdapter = new DsNguoiMuonAdapter(this,arrayDsNguoiMuon);
        lvNguoiMuon.setAdapter(dsNguoiMuonAdapter);
        getDataNguoiMuon();
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.add_Nguoi_Muon);
        floatingActionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                ThemNguoiMuon();
            }
        });
    }
    private void getview(){
        lvNguoiMuon = (ListView) findViewById(R.id.lvNguoiMuon);
    }
    private void ThemNguoiMuon(){
        Intent intent = new Intent(DsNguoiMuon.this, ThemNguoiMuon.class);
        startActivity(intent);
    }
    public void getDataNguoiMuon(){
        arrayDsNguoiMuon.clear();
        arrayDsNguoiMuon = db.getDataNM(arrayDsNguoiMuon);
        dsNguoiMuonAdapter.notifyDataSetChanged();
    }
    public void dialogUpdateSV(final String MaSV, String TenSV, String Lop, String Sdt){
        final AlertDialog.Builder alert = new AlertDialog.Builder(DsNguoiMuon.this);
        View mViewEditSV = (View) getLayoutInflater().inflate(R.layout.edit_nguoi_muon,null);
        alert.setView(mViewEditSV);
        final AlertDialog alertDialog = alert.create();
        alertDialog.setCanceledOnTouchOutside(false);
        final EditText etEditTenNM = (EditText) mViewEditSV.findViewById(R.id.etEditTenNM);
        final EditText etEditLopNM = (EditText) mViewEditSV.findViewById(R.id.etEditLopNM);
        final EditText etEditPhone = (EditText) mViewEditSV.findViewById(R.id.etEditPhone);
        Button btnEditSV = (Button) mViewEditSV.findViewById(R.id.btnEditSV);
        Button btnCancelEditSV = (Button) mViewEditSV.findViewById(R.id.btnCancelEditSV);
        etEditTenNM.setText(TenSV);
        etEditLopNM.setText(Lop);
        etEditPhone.setText(Sdt);
        btnCancelEditSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        btnEditSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean upDateSV = db.upDateSV(MaSV,etEditTenNM.getText().toString(),etEditLopNM.getText().toString(),etEditPhone.getText().toString());
                if (upDateSV == true){
                    Toast.makeText(getApplicationContext(), "Cập nhật thông tin thành công!", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                    getDataNguoiMuon();
                }
                else {
                    alertDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Cập nhật thông tin thất bại!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alertDialog.show();
    }
    public void dialogDeleteSV(final String MaSV){
        final AlertDialog.Builder alert = new AlertDialog.Builder(DsNguoiMuon.this);
        View mViewEditSach = (View) getLayoutInflater().inflate(R.layout.dialog_xoa,null);
        alert.setView(mViewEditSach);
        final AlertDialog alertDialog = alert.create();
        alertDialog.setCanceledOnTouchOutside(false);
        Button btnHuy = (Button) mViewEditSach.findViewById(R.id.btnHuy);
        Button btnXoa = (Button) mViewEditSach.findViewById(R.id.btnXoa);
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean DeleteSV = db.DeleteSV(MaSV);
                if (DeleteSV == true){Toast.makeText(getApplicationContext(), "Xóa thông tin thành công!", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                    getDataNguoiMuon();
                }
                else {
                    alertDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Xóa thông tin thất bại!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alertDialog.show();
    }
   // @Override
    //public boolean onCreateOptionsMenu(Menu menu) {
        //MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.menu_app,menu);
        //SearchView searchView = (SearchView) menu.findItem(R.id.menuSearch).getActionView();
        //searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //@Override
            //public boolean onQueryTextSubmit(String s) {
               // return false;
            //}

           // @Override
            //public boolean onQueryTextChange(String s) {
                //arrayDsNguoiMuon.clear();
               // arrayDsNguoiMuon = db.TimKiemSV(arrayDsNguoiMuon,s);
               //dsNguoiMuonAdapter.notifyDataSetChanged();
               // return false;
            //}
        //});
        //return super.onCreateOptionsMenu(menu);
    //}
}