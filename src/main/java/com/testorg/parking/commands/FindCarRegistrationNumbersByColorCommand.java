package com.testorg.parking.commands;

import com.testorg.parking.model.ParkingLot;
import com.testorg.parking.model.Slot;

import java.util.List;
import java.util.stream.Collectors;

public class FindCarRegistrationNumbersByColorCommand implements Command {

    @Override
    public void execute(ParkingLot parkingLot, String[] args) {
        List<Slot> allocatedSlots = parkingLot.getAllocatedParkingSlotByVehicleColor(args[1]);
        String nos = allocatedSlots.stream()
                .map(slot -> slot.getVehicle().getRegistrationNumber())
                .collect(Collectors.joining(","));
        System.out.println(nos);
    }
}