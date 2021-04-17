package com.example.carpickerdia;

import androidx.lifecycle.LiveData;

public class CarViewModel {
    CarRepository repository;

    public CarViewModel(){
        repository = CarRepository.getInstance();
    }

    LiveData<Car> getSearchedCar() {
        return repository.getSearchedCar();
    }

    public void searchForPokemon(String s){
        repository.getSearchedCar();
    }
}
