package com.testorg.parking.commands;

import com.testorg.parking.model.ParkingLot;
import com.testorg.parking.model.Slot;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllocatedSlotsByVehicleColorCommand implements Command {

    @Override
    public void execute(ParkingLot parkingLot, String[] args) {
        List<Slot> allocatedSlots = parkingLot.getAllocatedParkingSlotByVehicleColor();
        String matchingSlotNos = allocatedSlots.stream()
                .map(slot -> String.valueOf(slot.getNumber()))
                .collect(Collectors.joining(","));
        System.out.println(matchingSlotNos);
    }
}
