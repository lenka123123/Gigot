package com.example.administrator.gigot;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GigotApp extends Application {

//http://gank.io/api/data/%E7%A6%8F%E5%88%A9/3/1
    private static final String BASEURL="";
    public static  Retrofit retrofit;private  java.util.List<String> ptNo ;

    @Override
    public void onCreate() {
        super.onCreate();

        init();
    }

    private void init() {
        //步骤4:创建Retrofit对象
        // 设置 网络请求 Url
//设置使用Gson解析(记得加入依赖)
        retrofit = new Retrofit.Builder()
                .baseUrl("http://gank.io") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();

    }
}
