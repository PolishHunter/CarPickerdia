package com.example.carpickerdia.viewmodels.casual;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.carpickerdia.models.Car;
import com.example.carpickerdia.repositories.CarRepository;
import com.example.carpickerdia.repositories.InfoRepository;

import java.util.List;

public class InfoViewModel extends ViewModel {

    InfoRepository infoRepository;

    public InfoViewModel(){
        infoRepository = InfoRepository.getInstance();
    }

    public LiveData<String> getRandomBrand() {
        return infoRepository.getRandomBrand();
    }

    public void generateRandomBrand() {
        infoRepository.generateRandomBrand();
    }

    public void generateRandomPick(String make) {
        if(make==null || make.equals("")){
            infoRepository.generateRandomPick();
        }
        else{
            infoRepository.generateCarsAccordingToBrand(make);
        }
    }
}
