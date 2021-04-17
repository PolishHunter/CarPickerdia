package com.example.carpickerdia;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Car.class}, version = 1)
public abstract class CarDatabase extends RoomDatabase {
    private static CarDatabase instance;

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
