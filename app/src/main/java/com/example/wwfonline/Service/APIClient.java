package com.example.wwfonline.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIClient {
    private static APIClient mInstance;
    private static final String BASE_URL = "http://45e90433.ngrok.io/";
    private Retrofit mRetrofit;

    private APIClient() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static APIClient getInstance() {
        if (mInstance == null) {
            mInstance = new APIClient();
        }
        return mInstance;
    }

    public WWF_Service getAPI() {
        return mRetrofit.create(WWF_Service.class);
    }
}