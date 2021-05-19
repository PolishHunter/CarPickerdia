package com.example.carpickerdia.networking;

import com.example.carpickerdia.networking.CarApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static CarApi carApi;

    public static CarApi getCarApi(){
        if(carApi == null) {
            carApi = new Retrofit.Builder()
                    .baseUrl("https://private-anon-56bbd58d64-carsapi1.apiary-mock.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(CarApi.class);
        }
        return carApi;
    }
}
