package com.example.film.data.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitB {

    private RetrofitB() {
    }

    private static Api instance;

    public static Api getInstance(){
        if(instance==null){
            instance = initInstance();
        }
        return instance;
    }

    private static Api initInstance() {
        return new Retrofit
                .Builder()
                .baseUrl("https://ghibliapi.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api.class);


    }
}
