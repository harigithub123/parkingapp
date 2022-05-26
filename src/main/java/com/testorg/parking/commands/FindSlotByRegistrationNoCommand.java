package com.testorg.parking.commands;

import com.testorg.parking.model.ParkingLot;
import com.testorg.parking.model.Slot;

import java.util.Optional;

public class FindSlotByRegistrationNoCommand implements Command {
    @Override
    public void execute(ParkingLot parkingLot, String[] args) {
        Optional<Slot> allocatedSlot = parkingLot.isCarParkedWithRegistrationNo(args[1]);
        System.out.println(allocatedSlot.isPresent() ? allocatedSlot.get().getNumber() : "Not Found");
    }
}
