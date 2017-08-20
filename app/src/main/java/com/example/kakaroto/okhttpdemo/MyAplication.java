package com.example.kakaroto.okhttpdemo;

import android.app.Application;

import okhttp3.OkHttpClient;

/**
 * Created by kakaroto on 09/08/17.
 */

public class MyAplication extends Application {

    private static OkHttpClient okHttpClient;

    @Override
    public void onCreate() {
        super.onCreate();
        okHttpClient = new OkHttpClient();
    }

    public static OkHttpClient getClient() {
        return okHttpClient;
    }
}
