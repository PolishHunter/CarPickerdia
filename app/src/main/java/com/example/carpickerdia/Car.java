package com.example.carpickerdia;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "car_table")
public class Car {

    @PrimaryKey(autoGenerate = true)
    private final String brand;
    private final String model;
    private final String type;
    private final int horsepower;
    private final int tankSpace;
    private final double acceleration;
    private final double topSpeed;
    private final double consumption;
    private final double trunkSpace;
    private final String imageUrl;

    public Car(String brand, String model, String type, int horsepower, int tankSpace,
               double acceleration, double topSpeed, double consumption, double trunkSpace, String imageUrl){
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.horsepower = horsepower;
        this.tankSpace = tankSpace;
        this.acceleration = acceleration;
        this.topSpeed = topSpeed;
        this.consumption = consumption;
        this.trunkSpace = trunkSpace;
        this.imageUrl = imageUrl;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getTankSpace() {
        return tankSpace;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public double getConsumption() {
        return consumption;
    }

    public double getTrunkSpace() {
        return trunkSpace;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

