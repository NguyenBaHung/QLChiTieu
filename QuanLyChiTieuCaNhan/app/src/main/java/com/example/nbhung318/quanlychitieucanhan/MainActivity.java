package com.example.nbhung318.quanlychitieucanhan;

import android.app.TabActivity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
    private ViewPager vpThoigian;
    private TabLayout tlThoigian;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        vpThoigian.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tlThoigian.setupWithViewPager(vpThoigian);

    }

    private void AnhXa() {
        vpThoigian = (ViewPager) findViewById(R.id.viewPager);
        tlThoigian = (TabLayout) findViewById(R.id.tablayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chinh,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.itDachucnang:
                Intent intentDCN = new Intent(MainActivity.this,DaChucNangActivity.class);
                startActivity(intentDCN);
                break;
            case R.id.itThongbao:
                break;
            case R.id.itNamTruoc:
                Intent intentNT = new Intent(MainActivity.this,ThuActivity.class);
                startActivity(intentNT);
                break;
            case R.id.itNamNay:
                break;
            case R.id.itNamSau:
                break;
            case R.id.itGioithieu:
                Intent intentGT = new Intent(MainActivity.this,GioiThieuActivity.class);
                startActivity(intentGT);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
