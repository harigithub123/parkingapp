package com.testorg.parking.commands;

import com.testorg.parking.model.ParkingLot;

public interface Command {
    public void execute(ParkingLot parking, String[] args);
}
