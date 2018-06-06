package com.example.administrator.gigot.main.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.administrator.gigot.R;
import com.example.administrator.gigot.main.common.LogUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivityTestNet extends AppCompatActivity implements View {


    private RecyclerView rv;
    private Per per;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
        initView();

        LogUtils.i("", "Success: aaaaaaaaa MainActivityTestNet");
    }


    private void initView() {
        rv = (RecyclerView) findViewById(R.id.recycle);
        per = new Per(this);
        per.getData();
    }


    @Override
    public void Succee(BeaseMM listBeen) {
        List<BeaseMM> c = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            BeaseMM beaseMM = new BeaseMM();
            c.add(beaseMM);
        }
        MyAdapter a = new MyAdapter(MainActivityTestNet.this, c);
        rv.setLayoutManager(new LinearLayoutManager(MainActivityTestNet.this));
        rv.setAdapter(a);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        per.onDeattch();
    }
}