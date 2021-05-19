package com.example.carpickerdia.viewmodels.casual;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.carpickerdia.models.Car;
import com.example.carpickerdia.repositories.InfoRepository;

import java.util.List;

public class ResultsViewModel extends ViewModel {

    InfoRepository infoRepository;

    public ResultsViewModel(){
        infoRepository = InfoRepository.getInstance();
    }

    public LiveData<List<Car>> getRandomCars() {
        return infoRepository.getRandomCars();
    }

}
