package com.example.nbhung318.quanlychitieucanhan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class DaChucNangActivity extends AppCompatActivity {

    ListView listViewChucNang;
    ArrayList<DaChucNang> daChucNangArrayList;
    ChucNangAdapter chucNangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_da_chuc_nang);

        AnhXa();
        chucNangAdapter = new ChucNangAdapter(this,R.layout.dong_da_chuc_nang,daChucNangArrayList);
        listViewChucNang.setAdapter(chucNangAdapter);

        listViewChucNang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intentThemThu = new Intent(DaChucNangActivity.this,ThemThuActivity.class);
                    startActivity(intentThemThu);
                }
                if (position==1){
                    Intent intentThemChi = new Intent(DaChucNangActivity.this,ThemChiActivity.class);
                    startActivity(intentThemChi);
                }
                if (position==2){
                    Intent intentThemVay = new Intent(DaChucNangActivity.this,ThemVayActivity.class);
                    startActivity(intentThemVay);
                }
            }
        });
    }

    private void AnhXa(){
        listViewChucNang  = (ListView) findViewById(R.id.lvChucNang);
        daChucNangArrayList = new ArrayList<>();
        daChucNangArrayList.add(new DaChucNang("Thêm khoản thu",R.drawable.package_add));
        daChucNangArrayList.add(new DaChucNang("Thêm khoản chi",R.drawable.package_delete));
        daChucNangArrayList.add(new DaChucNang("Thêm khoản vay",R.drawable.package_accept));
    }



}


