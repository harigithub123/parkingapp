package com.testorg.parking.commands;

import com.testorg.parking.model.ParkingLot;
import com.testorg.parking.model.Slot;

public class StatusCommand implements Command {
    @Override
    public void execute(ParkingLot parkingLot, String[] args) {
        System.out.println("Slot No. Registration No. Colour");
        for (Slot slot : parkingLot.getAllocatedParkingSlots()) {
            System.out.println(slot.getNumber() + "\t"
                    + slot.getVehicle().getRegistrationNumber()
                    + "\t" + slot.getVehicle().getColour());
        }
    }
}
