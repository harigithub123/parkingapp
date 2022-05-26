package com.testorg.parking.model.commands;

import com.testorg.parking.model.Parking;

public interface Command {
    public void execute(Parking parking);
}
