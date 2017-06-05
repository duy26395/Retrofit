package com.example.duy.retrofit.RESTAPI;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by duy on 30/05/2017.
 */

public class ServiceGenerator {
    private static final String BASE_URL = "https://reqres.in/";

    private static Retrofit retrofit;
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());
    // khai báo kog để lấy ra giá trị của yêu cầu
    private static HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    private static OkHttpClient.Builder okclientbuilder = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor);
    private static OkHttpClient okclient = okclientbuilder.build();

    public static <T> T createService(Class<T> serTClass){
        if(retrofit == null){
            retrofit = builder.client(okclient).build();
        }
        return retrofit.create(serTClass);
    }
}
