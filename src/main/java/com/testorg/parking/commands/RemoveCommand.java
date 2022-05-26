package com.testorg.parking.commands;

import com.testorg.parking.model.ParkingLot;

public class RemoveCommand implements Command {

    @Override
    public void execute(ParkingLot parkingLot, String[] args) {
        int slot = Integer.parseInt(args[1]);
        parkingLot.removeVehicle(slot);
        System.out.println("Slot number " + slot + " is free");
    }
}
