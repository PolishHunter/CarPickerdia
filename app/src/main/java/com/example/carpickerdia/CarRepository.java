package com.example.carpickerdia;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CarRepository {
    private static CarRepository instance;
    private final MutableLiveData<Car> insertedCar;

    private CarRepository() {
        insertedCar = new MutableLiveData<>();
    }

    public static synchronized CarRepository getInstance() {
        if(instance == null) {
            instance = new CarRepository();
        }
        return instance;
    }

    public LiveData<Car> getSearchedCar() {
        return insertedCar;
    }
}
