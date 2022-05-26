package com.testorg.parking.model;

import java.util.ArrayList;
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

    public void parkVehicle(Vehicle vehicle) {
        int slot = getAvailableSlot();
        if(slot == -1) {
            System.out.println("Sorry, parking lot is full");
            return;
        }
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

    public void removeVehicle(int slot) {
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
        List<Slot> slots = getSlotsByVehicleColor(color);
        String nos = slots.stream()
                .map(slot -> slot.getVehicle().getRegistrationNumber())
                .collect(Collectors.joining(","));
        System.out.println(nos);
    }

    private List<Slot> getSlotsByVehicleColor(String color) {
        return parkingSlots.stream()
                .filter(slot -> color.equals(slot.getVehicle().getColour()))
                .collect(Collectors.toList());
    }

    public void getSlotNumbersByColor(String color) {
        List<Slot> slots = getSlotsByVehicleColor(color);
        String nos = slots.stream()
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
