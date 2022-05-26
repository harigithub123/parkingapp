package com.testorg.parking.model;

public class Vehicle {
    private String registrationNumber;
    private String colour;

    public Vehicle(String registrationNo, String color) {
        this.registrationNumber = registrationNo;
        this.colour = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColour() {
        return colour;
    }
}
