package com.example.kakaroto.okhttpdemo.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by kakaroto on 18/08/17.
 */

public class Api {
    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(new OkHttpClient())
                    .baseUrl("")
                    .build();
        }
        return retrofit;
    }

    public static Service getService() {
        return getClient().create(Service.class);
    }
}
