package com.example.administrator.gigot.main.home;

import android.app.Application;

import com.example.administrator.gigot.R;
import com.example.administrator.gigot.net.LoggingInterceptor;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import okhttp3.OkHttpClient;

public class   Myapp extends Application {

   public static String baseurl = "http://gank.io";
    public static OkHttpClient ok;

    @Override
    public void onCreate() {
        super.onCreate();


        ok = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();





        ImageLoaderConfiguration con=new ImageLoaderConfiguration.Builder(this)
                .threadPriority(100)
                .threadPoolSize(3)
                .memoryCacheExtraOptions(200,200)
                .memoryCacheSize(2*1024*1024)
                .diskCacheSize(50*1024*1024)
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .build();
        ImageLoader.getInstance().init(con);
    }
    public static DisplayImageOptions getDisk(){
        DisplayImageOptions options=new DisplayImageOptions.Builder()
                .showImageOnFail(R.mipmap.ic_launcher)
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .build();
        return options;
    }
}