package com.example.administrator.gigot.main.home;


import android.util.Log;

import com.example.administrator.gigot.main.common.LogUtils;
import com.example.administrator.gigot.net.Model;

import java.lang.ref.WeakReference;

public class Per implements  Gong<View>{
    private Model model;
    //软引用
    private WeakReference<View> weak;
    public Per (View view1){
        this.model=new Model();
        onAttach(view1);
        model.setGetdata(new Model.Getdata() {
            @Override
            public void Success(BeaseMM listBeen) {
                LogUtils.i("", "Success111111: pppp ");
                weak.get().Succee(listBeen);
            }
        });
    }
    //拿到数据
    public void getData(){
        model.Getdata( );
    }

    //////////////
    @Override
    public void onAttach(View view) {
        weak=new WeakReference<View>(view);
    }

    @Override
    public void onDeattch() {
        weak.clear();
    }
}