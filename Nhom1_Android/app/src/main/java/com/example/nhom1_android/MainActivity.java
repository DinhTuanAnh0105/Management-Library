package com.example.nhom1_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    String tkDangNhap;
    public static final String etAddMasv2  = "masingvien";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        Intent intent = getIntent();
        tkDangNhap = intent.getStringExtra(DangNhap.etAddMasv);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void logOut(View view) {
        Intent goToLogin = new Intent(MainActivity.this, DangNhap.class);
        startActivity(goToLogin);
        Toast.makeText(this, "Đã đăng xuất", Toast.LENGTH_SHORT).show();
    }

    public void gotoInfo(View view) {
        Intent intent = new Intent(MainActivity.this, ThongTin.class);
        startActivity(intent);
    }
    public void gotoQuyDinh(View view) {
        Intent intent = new Intent(MainActivity.this, QuyDinh.class);
        startActivity(intent);
    }

    public void gotoDoiMK(View view) {
        Intent intent = new Intent(MainActivity.this, DoiMatKhau.class);
        intent.putExtra(etAddMasv2, tkDangNhap);
        startActivity(intent);
    }

    public void gotoDsSach(View view) {
        Intent intent = new Intent(MainActivity.this, DsSach.class);
        startActivity(intent);
    }

    public void gotoDsNguoiMuon(View view) {
        Intent intent = new Intent(MainActivity.this, DsNguoiMuon.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_info) {
            Intent intent = new Intent(MainActivity.this, ThongTin.class);
            startActivity(intent);
        } else if (id == R.id.nav_logout) {
            Intent goToLogin = new Intent(MainActivity.this, DangNhap.class);
            startActivity(goToLogin);
            Toast.makeText(this, "Đã đăng xuất", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_DoiMK) {
            Intent intent = new Intent(MainActivity.this, DoiMatKhau.class);
            intent.putExtra(etAddMasv2, tkDangNhap);
            startActivity(intent);
        } else if (id == R.id.nav_sach) {
            Intent intent = new Intent(MainActivity.this, DsSach.class);
            startActivity(intent);
        } else if (id == R.id.nav_sv) {
            Intent intent = new Intent(MainActivity.this, DsNguoiMuon.class);
            startActivity(intent);
        }else if (id == R.id.nav_quydinh) {
            Intent intent = new Intent(MainActivity.this, QuyDinh.class);
            startActivity(intent);
        }
            return false;
        }
    }
