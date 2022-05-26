package com.testorg.parking.commands;

import com.testorg.parking.model.ParkingLot;
import com.testorg.parking.model.Slot;

import java.util.Optional;

public class FindSlotByRegistrationNoCommand implements Command {

    @Override
    public void execute(ParkingLot parkingLot, String[] args) {
        Optional<Slot> matchingSlot = parkingLot.getParkingSlots()
                .stream()
                .filter(slot -> args[1].equals(slot.getVehicle().getRegistrationNumber()))
                .findAny();
        System.out.println(matchingSlot.isPresent() ? matchingSlot.get().getNumber() : "Not Found");
    }
}
