package com.example.kakaroto.okhttpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.kakaroto.okhttpdemo.api.Api;

import java.io.IOException;

import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void doLogin(String email, String pass) {

        retrofit2.Call<ResponseBody> call = Api.getService().login(email, pass);

        call.enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        Log.d(TAG, "onResponse: " + response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else Log.d(TAG, "onResponse: " + response.message());
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                t.printStackTrace();
            }
        });

    }

    private void wayBill(String wayBill, String courier) {
        retrofit2.Call<ResponseBody> call = Api.getService().wayBill(wayBill, courier);
        call.enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call,
                                   retrofit2.Response<ResponseBody> response) {


                if (response.isSuccessful()) {
                    try {
                        Log.d(TAG, "onResponse waybill: " + response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else
                    Log.d(TAG, "onResponse watbill not success: " + response.message());

            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure waybill: " + t.getMessage());
                t.printStackTrace();
            }
        });
    }

    private void getCity(String id, String province) {
        retrofit2.Call<ResponseBody> call = Api.getService().getCity(id, province);

        call.enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call,
                                   retrofit2.Response<ResponseBody> response) {

                if (response.isSuccessful()) {
                    try {
                        Log.d(TAG, "onResponse data city: " + response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else Log.d(TAG, "onResponse data city not success: " + response.message());

            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure data city: " + t.getMessage());
                t.printStackTrace();
            }
        });
    }

}
