package com.example.administrator.gigot.net;

import com.example.administrator.gigot.main.home.Bean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Interface {
    @GET("columns/getVideoList.do")
    Observable<Bean> getBean(@Query("catalogId") String catalogId, @Query("pnum") int pnum);

    @GET("api/data/%E7%A6%8F%E5%88%A9/3/1")
    Observable<Fulibean> getMn( );
}