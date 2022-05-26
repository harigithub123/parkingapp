package com;

import com.testorg.parking.model.ParkingLot;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Welcome");
        Scanner sc = new Scanner(System.in);
        String stringCommand = sc.nextLine();
        String[] values = stringCommand.split(" ");
        ParkingLot parkingLot = new ParkingLot(Integer.parseInt(values[1]));
        while(true) {
            stringCommand = sc.nextLine();
            parkingLot.run(stringCommand);
        }
    }
}
