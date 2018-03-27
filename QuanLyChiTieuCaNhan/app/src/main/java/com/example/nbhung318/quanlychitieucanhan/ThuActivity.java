package com.example.nbhung318.quanlychitieucanhan;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThuActivity extends AppCompatActivity {

    Toolbar tbThu;
    ListView lvThu;
    ThuAdapter thuAdapter;
    ArrayList<Thu> thuArrayList;
    View footerview;
    int page = 1;
    boolean isLoading = false;
    boolean limitadata = false;
    mHandler mHandler;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thu);

        Anhxa();
        if (CheckConnect.haveNetworkConnection(getApplicationContext())){
            ActionToolbar();
            GetData(page);
            LoadMoreData();
        }else {
            CheckConnect.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại internet");
            finish();
        }

    }
    private void LoadMoreData() {

        lvThu.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override
            public void onScroll(AbsListView absListView, int FirstItem, int VisibleItem, int TotalItem) {
                if (FirstItem +VisibleItem ==  TotalItem && TotalItem != 0 && isLoading == false && limitadata == false){
                    isLoading = true;
                    ThreadData threadData = new ThreadData();
                    threadData.start();

                }
            }
        });
    }

    private void GetData(int Page) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongdanthu= KetNoiDB.danhSachThu;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, duongdanthu, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int Id = 0;
                int Sotienthu = 0;
                String Noidungthu = "";
                int Thoigianthu = 0;
                if(response != null && response.length() != 2){
                    lvThu.removeFooterView(footerview);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0;i<jsonArray.length();i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            Id = jsonObject.getInt("id");
                            Sotienthu = jsonObject.getInt("sotienthu");
                            Noidungthu = jsonObject.getString("noidungthu");
                            Thoigianthu = jsonObject.getInt("thoigianthu");
                            thuArrayList.add(new Thu(Id,Sotienthu,Noidungthu,Thoigianthu));
                            thuAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else {
                    limitadata = true;
                    lvThu.removeFooterView(footerview);
                    CheckConnect.ShowToast_Short(getApplicationContext(),"Đã hết dữ liệu");
                }
            }
        },new Response.ErrorListener(){
            public void onErrorResponse(VolleyError error){

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param = new HashMap<String,String>();
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void ActionToolbar() {
        setSupportActionBar(tbThu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbThu.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setSupportActionBar(Toolbar tbThu) {
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void Anhxa() {
        tbThu = (Toolbar) findViewById(R.id.toolbarthu);
        lvThu = (ListView) findViewById(R.id.listviewthu);
        thuArrayList = new ArrayList<>();
        thuAdapter = new ThuAdapter(getApplicationContext(),thuArrayList);
        lvThu.setAdapter(thuAdapter);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerview = inflater.inflate(R.layout.progressbar,null);
        mHandler = new mHandler();

    }
    public  class mHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    lvThu.addFooterView(footerview);
                    break;
                case 1:
                    GetData(++page);
                    isLoading = false;
                    break;
            }
            super.handleMessage(msg);
        }
    }
    public class ThreadData extends Thread{
        @Override
        public void run() {
            mHandler.sendEmptyMessage(0);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = mHandler.obtainMessage(1);
            mHandler.sendMessage(message);
            super.run();
        }
    }
}

