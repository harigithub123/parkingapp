package com.testorg.parking.model;

import com.testorg.parking.commands.Command;
import com.testorg.parking.parser.StringCommandParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class ParkingLot {
    private int noOfSlots;
    private List<Slot> parkingSlots;

    public ParkingLot(int noOfSlots) {
        this.noOfSlots = noOfSlots;
        initializeSlots(noOfSlots);
        System.out.println("Created a parking lot with " + this.noOfSlots + " slots");
    }

    public void processCommand(String stringCommand) {
        String[] values = stringCommand.split(" ");
        Command command = StringCommandParser.toCommand(values[0]);
        if (isNull(command)) {
            System.out.println("Invalid Command");
            return;
        }
        command.execute(this, values);
    }

    public void initializeSlots(int noOfSlots) {
        parkingSlots = new ArrayList<>();
        for (int i = 1; i <= this.noOfSlots; i++) {
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

    public void removeVehicle(int slot) {
        this.parkingSlots.get(slot - 1).removeVehicle();
    }

    /*
    ideally We should return response object so that we can identify what happen to our park request.
    e.g 0 - full, 1 = vehicle parked, -1 = vehicle is over size
     */
    public Optional<Slot> parkVehicle(Vehicle vehicle) {
        Optional<Slot> slot = this.getAvailableSlot();
        if (slot.isEmpty()) {
            System.out.println("Sorry, parking lot is full");
            return slot;
        }
        slot.get().park(vehicle);
        return slot;
    }

    public List<Slot> getAllocatedParkingSlots() {
        return this.parkingSlots.stream()
                .filter(slot -> slot.isAllocated())
                .collect(Collectors.toList());
    }

    public List<Slot> getAllocatedParkingSlotByVehicleColor() {
        return this.parkingSlots.stream()
                .filter(slot -> slot.isAllocated())
                .collect(Collectors.toList());
    }

    public Optional<Slot> isCarParkedWithRegistrationNo(String registrationNo) {
        return this.parkingSlots
                .stream()
                .filter(slot -> registrationNo.equals(slot.getVehicle().getRegistrationNumber()))
                .findAny();
    }
}
