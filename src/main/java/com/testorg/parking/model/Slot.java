package com.testorg.parking.model;

import static java.util.Objects.nonNull;

public class Slot {
    private int number;
    private Vehicle vehicle;

    public Slot(int slot) {
        this.number = slot;
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

    public boolean isAllocated() {
        return nonNull(this.vehicle);
    }
}
