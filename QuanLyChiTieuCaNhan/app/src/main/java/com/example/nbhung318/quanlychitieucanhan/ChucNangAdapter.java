package com.example.nbhung318.quanlychitieucanhan;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import javax.xml.transform.Templates;

/**
 * Created by Hung on 3/19/2018.
 */

public class ChucNangAdapter extends ArrayAdapter<DaChucNang> {
    private Activity context;
    private int layout;
    private List<DaChucNang> daChucNangList;


    public ChucNangAdapter(@NonNull Activity context, int resource, @NonNull List<DaChucNang> objects) {
        super(context, resource, objects);
        this.context=context;
        this.layout=resource;
        this.daChucNangList=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View view=inflater.inflate(layout,null);
        TextView txtAnh=view.findViewById(R.id.txtTen);
        ImageView imgAnh=view.findViewById(R.id.imgvHinh);
        DaChucNang dcn=daChucNangList.get(position);
        txtAnh.setText(dcn.getTen());
        imgAnh.setImageResource(dcn.getHinh());
        return view;
    }
}
