package com.testorg.parking.commands;

import com.testorg.parking.model.ParkingLot;
import com.testorg.parking.model.Slot;
import com.testorg.parking.model.Vehicle;

import java.util.Optional;

public class ParkCommand implements Command {

    @Override
    public void execute(ParkingLot parkingLot, String[] args) {
        Optional<Slot> allocatedSlot = parkingLot.parkVehicle(new Vehicle(args[1], args[2]));
        System.out.println(allocatedSlot.isEmpty() ?
                "Sorry, parking lot is full" : "Allocated slot number: " + allocatedSlot.get().getNumber());
    }
}
