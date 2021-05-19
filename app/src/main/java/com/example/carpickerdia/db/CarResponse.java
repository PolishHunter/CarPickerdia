package com.example.carpickerdia.db;

import com.example.carpickerdia.models.Car;

public class CarResponse {

    private String make;
    private String model;
    private int year;
    private int id;
    private int horsepower;
    private int price;
    private String img_url;

   public Car getCar(){
       return new Car(make, model, year, id, horsepower, price, img_url);
  }
}

