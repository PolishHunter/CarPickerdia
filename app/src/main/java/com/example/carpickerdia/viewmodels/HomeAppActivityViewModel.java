package com.example.carpickerdia.viewmodels;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.carpickerdia.repositories.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class HomeAppActivityViewModel extends AndroidViewModel {

    private final UserRepository userRepository;

    public HomeAppActivityViewModel(Application app){
        super(app);
        userRepository = UserRepository.getInstance(app);
    }

    public LiveData<FirebaseUser> getCurrentUser(){
        return userRepository.getCurrentUser();
    }

    public void signOut() {
        userRepository.signOut();
    }
}
