package com.testorg.parking.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.util.Objects.isNull;

public class ParkingLot {
    private int noOfSlots;
    private List<Slot> parkingSlots;

    public ParkingLot(int noOfSlots) {
        this.noOfSlots = noOfSlots;
        initializeSlots(noOfSlots);
    }

    public void initializeSlots(int noOfSlots) {
        parkingSlots = new ArrayList<>();
        for(int i = 1; i<= this.noOfSlots; i++) {
            parkingSlots.add(new Slot(i));
        }
    }

    public Optional<Slot> getAvailableSlot() {
        Optional<Slot> slot = parkingSlots
                .stream()
                .filter(s -> !s.isAllocated())
                .findFirst();
        return slot;
    }

    public Integer getNoOfSlots() {
        return this.noOfSlots;
    }

    public List<Slot> getParkingSlots() {
        return parkingSlots;
    }
}
