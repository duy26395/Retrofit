package com.example.duy.retrofit.RESTAPI;

import com.example.duy.retrofit.Data;
import com.example.duy.retrofit.data2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by duy on 30/05/2017.
 */

public interface Gitservice {//gawn gia tri cho user/:user name thay bang keywword,goi data de get giatri cho keyword
    @GET("api/users/{keywork}")
    Call<data2> getDataCall(@Path("keywork") String keyword);
}
