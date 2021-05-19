package com.example.carpickerdia.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "rating_table")
public class Rating {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private double rating;
    private String username;
    private String comment;


    public int getId() {
        return id;
    }

    public double getRating() {
        return rating;
    }

    public String getUsername() {
        return username;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
