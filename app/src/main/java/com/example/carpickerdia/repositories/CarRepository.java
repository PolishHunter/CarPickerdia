package com.example.carpickerdia.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.carpickerdia.models.Car;

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
