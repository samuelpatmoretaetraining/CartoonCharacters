package com.muelpatmore.cartooncharacters.data.network.network_utils;


import com.muelpatmore.cartooncharacters.BuildConfig;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Samuel on 05/12/2017.
 */

public class ServerConnectionManager {

    static Retrofit retrofit;
    static OkHttpClient okHttpClient;

    public static RequestInterface getServerConnection() {

        okHttpClient= new OkHttpClient.Builder().
                addInterceptor(new HttpLoggingInterceptor()).build();

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BuildConfig.api_base)
                .client(okHttpClient)
                .build();

        return retrofit.create(RequestInterface.class);
    }
}
