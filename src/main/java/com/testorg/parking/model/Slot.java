package com.testorg.parking.model;

public class Slot {
    private int number;
    private Vehicle vehicle;

    public Slot(int slot, Vehicle vehicle) {
        this.number = slot;
        this.vehicle = vehicle;
    }

    public int getNumber() {
        return number;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void removeVehicle() {
        this.vehicle = null;
    }
}
