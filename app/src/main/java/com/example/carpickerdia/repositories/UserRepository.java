package com.example.carpickerdia.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.carpickerdia.models.UserLiveData;
import com.example.carpickerdia.db.UserStatusLiveData;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserRepository {
     private final UserLiveData currentUser;
     private final Application application;
     private static UserRepository instance;


     private UserRepository(Application application){
          this.currentUser = new UserLiveData();
          this.application = application;
     }

     public LiveData<FirebaseUser> getCurrentUser() { return currentUser;}

     public static synchronized UserRepository getInstance(Application application){
          if(instance == null){
               instance = new UserRepository(application);
          }
          return instance;
     }

     public void signOut() {
          AuthUI.getInstance().signOut(application.getApplicationContext());
     }
}
