package com.example.carpickerdia;

public class CarResponse {
    private int id;
    private String name;
    private Specs specs;

//    public Car getCar(){
//        return new Car(id, name, specs.front_default);
//    }

    private static class Specs{
        private String front_default;
    }
}

