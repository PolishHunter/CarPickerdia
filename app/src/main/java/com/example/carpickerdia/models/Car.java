package com.example.carpickerdia.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Map;

@Entity(tableName = "car_table")
public class Car implements Comparable<Car> {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String make;
    private String model;
    private int year;
    private Integer horsepower;
    private int price;
    private String img_url;
    private Integer points;

    public Car(String make, String model,int year, int id, Integer horsepower, int price, String img_url){
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.horsepower = horsepower;
        this.price = price;
        this.img_url = img_url;
    }

    public Integer getPoints() {
        return points;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getId() {
        return id;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public int getPrice() {
        return price;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    @Override
    public String toString() {
        return "Car{" +
                "points=" + points +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return this.getPoints().compareTo(o.getPoints());
    }
}

