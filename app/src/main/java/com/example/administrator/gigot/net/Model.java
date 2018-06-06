package com.example.administrator.gigot.net;

import android.util.Log;

import com.example.administrator.gigot.main.home.Bean;
import com.example.administrator.gigot.main.home.BeaseMM;
import com.example.administrator.gigot.main.home.Myapp;

import okhttp3.OkHttpClient;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Model {


    public void Getdata( ) {
        // http://gank.io/api/data/%E7%A6%8F%E5%88%A9/3/1

        RetrofitUnitl.getInstance(Myapp.baseurl, Myapp.ok)
                .setCreate(Interface.class)
                .getMn()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Fulibean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("onError", "onEonErrorrror: ");
                    }

                    @Override
                    public void onNext(Fulibean listBeen) {
                        Log.i("onError", "onEonErrorrror: " + listBeen.isError());
                        Log.e("qq", listBeen.toString());
                        getdata.Success(null);
                    }
                });
    }

    Getdata getdata;

    public void setGetdata(Getdata getdata) {
        this.getdata = getdata; //赋值最终的那个
    }

    public interface Getdata {
        void Success(BeaseMM listBeen);
    }
}