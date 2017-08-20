package com.example.kakaroto.okhttpdemo.api;

import android.support.annotation.CallSuper;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by kakaroto on 18/08/17.
 */

public interface Service {

    String type = "application/json";
    String contentType = "Content-Type: " + type;
    String accept = "Accept: " + type;

    @Headers({contentType, accept})
    @GET("api/city")
    Call<ResponseBody> getCity(@Query("id") String id, @Query("province") String province);


    @Headers({accept, contentType})
    @POST("api/waybill")
    @FormUrlEncoded
    Call<ResponseBody> wayBill(@Field("waybill") String wayBill, @Field("courier") String courier);

    @FormUrlEncoded
    @POST("auth/login")
    Call<ResponseBody> login(@Field("email") String email, @Field("password") String pass);
}
