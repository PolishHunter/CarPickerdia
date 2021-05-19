package com.example.carpickerdia.viewmodels.mainapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.carpickerdia.db.UserStatusLiveData;
import com.example.carpickerdia.repositories.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class LoginViewModel extends AndroidViewModel {

    private UserRepository userRepository;

    public LoginViewModel(Application application) {
        super(application);
        userRepository = UserRepository.getInstance(application);
    }

    public LiveData<FirebaseUser> getCurrentUser() {
        return userRepository.getCurrentUser();
    }

    public UserStatusLiveData getStatus(){
        String userId = userRepository.getCurrentUser().getValue().getUid();
        return userRepository.getStatus(userId);
    }

    public void signOut() {
        userRepository.signOut();
    }
}
