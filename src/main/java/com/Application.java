package com;

import com.testorg.parking.commands.Command;
import com.testorg.parking.model.ParkingLot;
import com.testorg.parking.model.Vehicle;
import com.testorg.parking.parser.StringCommandParser;

import java.util.Scanner;

import static java.util.Objects.isNull;

public class Application {
    public static void main(String[] args) {
        System.out.println("Welcome");

        Scanner sc = new Scanner(System.in);
        Command command = null;
        String commandString = sc.nextLine();
        String[] values = commandString.split(" ");
        ParkingLot parkingLot = new ParkingLot(Integer.parseInt(values[1]));
        System.out.println("Created a parking lot with "+parkingLot.getNoOfSlots() +" slots");
        while(true) {
            commandString = sc.nextLine();
            values = commandString.split(" ");
            command = StringCommandParser.toCommand(values[0]);
            if(isNull(command)) {
                System.out.println("Invalid Command");
                continue;
            }
            command.execute(parkingLot, values);

        }

    }
}
