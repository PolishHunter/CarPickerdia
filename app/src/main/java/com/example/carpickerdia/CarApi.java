package com.example.carpickerdia;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CarApi {
    @GET("api/v2/car/{name}")
    Call<CarResponse> getCar(@Path("name") String name);
}
