package com.testorg.parking.commands;

import com.testorg.parking.model.ParkingLot;

public class RemoveCommand implements Command {

    @Override
    public void execute(ParkingLot parkingLot, String[] args) {
        int slot = Integer.parseInt(args[1]);
        parkingLot.getParkingSlots().get(slot-1).removeVehicle();
        System.out.println("Slot number " + slot + " is free");
    }
}
