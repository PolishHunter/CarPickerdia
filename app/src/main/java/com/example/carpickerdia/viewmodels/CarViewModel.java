package com.example.carpickerdia.viewmodels;

import androidx.lifecycle.LiveData;

import com.example.carpickerdia.models.Car;
import com.example.carpickerdia.repositories.CarRepository;

public class CarViewModel {
    CarRepository carRepository;

    public CarViewModel(){
        carRepository = CarRepository.getInstance();
    }

    LiveData<Car> getSearchedCar() {
        return carRepository.getSearchedCar();
    }

    public void searchForCar(String s){
        carRepository.getSearchedCar();
    }
}
