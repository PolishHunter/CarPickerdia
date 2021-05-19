package com.example.carpickerdia.networking;

import com.example.carpickerdia.db.CarResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CarApi {
    @GET("/cars")
    Call<List<CarResponse>> getCar();
}
