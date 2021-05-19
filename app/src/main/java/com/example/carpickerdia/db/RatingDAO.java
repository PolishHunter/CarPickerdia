package com.example.carpickerdia.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.carpickerdia.models.Car;
import com.example.carpickerdia.models.Rating;

import java.util.List;

@Dao
public interface RatingDAO {

    @Insert
    void insert(Rating rating);

    @Query("SELECT * FROM rating_table")
    LiveData<List<Rating>> getAllRatings();
}
