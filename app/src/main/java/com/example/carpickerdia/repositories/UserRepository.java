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
     private final Application application;
     private final UserLiveData currentUser;
     private static UserRepository instance;
     private DatabaseReference myRef;


     private UserRepository(Application application){
          this.application = application;
          this.currentUser = new UserLiveData();
     }

     public static synchronized UserRepository getInstance(Application application){
          if(instance == null){
               instance = new UserRepository(application);
          }
          return instance;
     }

     public void createUser(String uid, boolean isCar){
          myRef = FirebaseDatabase.getInstance().getReference().child("users").child(uid);
          myRef.setValue(isCar);
     }

     public UserStatusLiveData getStatus(String uid){
          myRef = FirebaseDatabase.getInstance().getReference("users");
          return new UserStatusLiveData(myRef, uid);
     }

     public LiveData<FirebaseUser> getCurrentUser() {
          return currentUser;
     }

     public void signOut() {
          AuthUI.getInstance().signOut(application.getApplicationContext());
     }
}
