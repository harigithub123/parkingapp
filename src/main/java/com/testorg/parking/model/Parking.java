package com.testorg.parking.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class Parking {
    private int noOfSlots;
    private List<Slot> parkingSlots;

    public Parking(int noOfSlots) {
        this.noOfSlots = noOfSlots;
        parkingSlots = new ArrayList<>();
    }

    public void park(String registrationNo, String color) {
        int slot = getAvailableSlot();
        if(slot == -1) {
            System.out.println("Sorry, parking lot is full");
            return;
        }
        Vehicle vehicle = new Vehicle(registrationNo, color);
        parkingSlots.get(slot).park(vehicle);
        System.out.println("Allocated slot number: "+ slot);
    }

    private int getAvailableSlot() {
        for(Slot s : parkingSlots) {
            if(isNull(s.getVehicle())) {
                return s.getNumber();
            }
        }
        return -1;
    }

    public void markSlotAsFree(int slot) {
        parkingSlots.get(slot).removeVehicle();
        System.out.println("Slot number "+slot+" is free");
    }

    public void getStatus() {
        System.out.println("Slot No. Registration No. Colour");
        for(Slot slot : parkingSlots) {
            System.out.println(slot.getNumber()+"\t"
                    +slot.getVehicle().getRegistrationNumber()
                    +"\t"+slot.getVehicle().getColour());
        }
    }

    public void getRegistrationNumbersByColor(String color) {
        String nos = parkingSlots.stream()
                .filter(slot -> color.equals(slot.getVehicle().getColour()))
                .map(slot -> slot.getVehicle().getRegistrationNumber())
                .collect(Collectors.joining(","));
        System.out.println(nos);
    }

    public void getSlotNumbersByColor(String color) {
        String nos = parkingSlots.stream()
                .filter(slot -> color.equals(slot.getVehicle().getColour()))
                .map(slot -> String.valueOf(slot.getNumber()))
                .collect(Collectors.joining(","));
        System.out.println(nos);
    }

    public void getSlotNoForGivenRegistrationNo(String registrationNo) {
        int slotNo = -1;
        for(Slot s : parkingSlots) {
            if(registrationNo.equals(s.getVehicle().getRegistrationNumber())) {
                slotNo = s.getNumber();
            }
        }
        System.out.println(slotNo == -1 ? "Not Found" : slotNo);
    }

    public Integer getNoOfSlots() {
        return this.noOfSlots;
    }
}
