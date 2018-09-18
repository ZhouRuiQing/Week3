package com.bwie.week3.utils;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpUtils {

    public OkHttpClient client;

    private static  OkHttpUtils okHttpUtils = new OkHttpUtils();

    public static OkHttpUtils getInstance() {

        if(okHttpUtils==null){
            synchronized (OkHttpUtils.class){
                okHttpUtils=new OkHttpUtils();
            }
        }

        return okHttpUtils;
    }

    public OkHttpUtils() {

        if(client==null){
            synchronized (OkHttpClient.class){
                client = new OkHttpClient.Builder().build();
            }
        }

    }

    public void  get(String url, Callback callback){

        Request build = new Request.Builder().url(url).build();

        client.newCall(build).enqueue(callback);
    }
}
