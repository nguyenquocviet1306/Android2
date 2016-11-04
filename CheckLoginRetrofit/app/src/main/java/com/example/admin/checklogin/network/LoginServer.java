package com.example.admin.checklogin.network;

import com.example.admin.checklogin.models.JSONModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Admin on 11/4/2016.
 */

public interface LoginServer {
    @POST("/api/{login}")
    Call<JSONModel> login(@Path("login") String postfix, @Body RequestBody params);
}
