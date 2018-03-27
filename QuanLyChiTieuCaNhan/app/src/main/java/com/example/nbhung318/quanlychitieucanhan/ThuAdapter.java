package com.example.nbhung318.quanlychitieucanhan;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Hung on 3/27/2018.
 */

public class ThuAdapter extends BaseAdapter {
    Context context;
    ArrayList<Thu> arrayListThu;

    public ThuAdapter(Context context, ArrayList<Thu> arrayListThu) {
        this.context = context;
        this.arrayListThu = arrayListThu;
    }

    @Override
    public int getCount() {
        return arrayListThu.size();
    }

    @Override
    public Object getItem(int position) {
        return getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder{
        public TextView txtSotienthu;
        public TextView txtNoidungthu;
        public TextView txtThoigianthu;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_thu,null);
            viewHolder.txtSotienthu = (TextView) convertView.findViewById(R.id.textviewSotienthu);
            viewHolder.txtNoidungthu = (TextView) convertView.findViewById(R.id.textviewNoidungthu);
            viewHolder.txtThoigianthu = (TextView) convertView.findViewById(R.id.textviewThoigianthu);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Thu thu = (Thu) getItem(position);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtSotienthu.setText("Số tiền : " + decimalFormat.format(thu.getSoTienThu())+ "Đ");
        viewHolder.txtNoidungthu.setMaxLines(2);
        viewHolder.txtNoidungthu.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtNoidungthu.setText(thu.getNoiDungThu());
        viewHolder.txtThoigianthu.setText(thu.getThoiGian().toString());
        return convertView;
    }
}
