package com.example.carpickerdia.viewmodels.expert;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.carpickerdia.repositories.InfoRepository;

import java.util.List;

public class AllBrandsViewModel extends ViewModel {
    InfoRepository infoRepository;

    public AllBrandsViewModel() {
        this.infoRepository = InfoRepository.getInstance();
    }

    public LiveData<List<String>> getAllBrands() {
        return infoRepository.getAllBrands();
    }

    public void getAllCarBrands() {
        infoRepository.getAllCarBrands();
    }
}
