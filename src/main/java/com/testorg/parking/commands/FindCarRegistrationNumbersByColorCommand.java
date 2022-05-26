package com.testorg.parking.commands;

import com.testorg.parking.model.ParkingLot;

import java.util.stream.Collectors;

public class FindCarRegistrationNumbersByColorCommand implements Command {

    @Override
    public void execute(ParkingLot parkingLot, String[] args) {
        String nos = parkingLot.getParkingSlots().stream()
                .filter(slot -> args[1].equals(slot.getVehicle().getColour()))
                .map(slot -> slot.getVehicle().getRegistrationNumber())
                .collect(Collectors.joining(","));
        System.out.println(nos);
    }
}
