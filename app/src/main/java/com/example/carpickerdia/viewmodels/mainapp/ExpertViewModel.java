package com.example.carpickerdia.viewmodels.mainapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.carpickerdia.repositories.InfoRepository;

import java.util.List;

public class ExpertViewModel extends ViewModel {
    InfoRepository infoRepository;

    public ExpertViewModel() {
        this.infoRepository = InfoRepository.getInstance();
    }

    public LiveData<List<String>> getAllBrands() {
        return infoRepository.getAllBrands();
    }
}
