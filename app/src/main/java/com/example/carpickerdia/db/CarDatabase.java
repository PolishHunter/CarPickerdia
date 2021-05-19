package com.example.carpickerdia.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.carpickerdia.models.Car;
import com.example.carpickerdia.models.Rating;

@Database(entities = {Car.class, Rating.class}, version = 2)
public abstract class CarDatabase extends RoomDatabase {
    private static CarDatabase instance;
    public abstract RatingDAO ratingDAO();

    public static synchronized CarDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context,
                    CarDatabase.class, "car_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
