package com.example.androidarchpattern_lab1.Model.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {

    private static Retrofit retrofit;
    static final String baseURl = "https://dummyjson.com/" ;

    public static synchronized Retrofit getInstance() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
