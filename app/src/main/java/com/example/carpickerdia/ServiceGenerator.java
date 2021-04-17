package com.example.carpickerdia;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static CarApi carApi;

    public static CarApi getCarApi(){
        if(carApi == null) {
            carApi = new Retrofit.Builder()
                    .baseUrl("https://sandbox.api.kbb.com/idws/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(CarApi.class);
        }
        return carApi;
    }
}
