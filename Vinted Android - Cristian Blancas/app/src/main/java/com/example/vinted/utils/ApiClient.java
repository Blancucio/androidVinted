package com.example.vinted.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL1 =
            //Poner la ip del ordenador en el que se este ejecutando
//            "http://192.168.104.70:8080/VintedApiV2/webresources/";
            "http://192.168.56.1:8080/VintedApiV2/webresources/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL1)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}