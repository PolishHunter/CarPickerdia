package com.example.carpickerdia.viewmodels.mainapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.carpickerdia.repositories.InfoRepository;

import java.util.List;

public class MainViewModel extends ViewModel {
    InfoRepository infoRepository;

    public MainViewModel() {
        this.infoRepository = InfoRepository.getInstance();
    }

    public void getAllBrands() {
        infoRepository.getAllCarBrands();
    }
}
