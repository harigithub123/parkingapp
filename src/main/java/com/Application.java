package com;

import com.testorg.parking.model.Parking;
import com.testorg.parking.model.Vehicle;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Welcome");

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        String[] values = command.split(" ");
        Parking parking = new Parking(Integer.parseInt(values[1]));
        System.out.println("Created a parking lot with "+parking.getNoOfSlots() +" slots");
        while(true) {
            command = sc.nextLine();
            values = command.split(" ");

            switch (values[0]) {
                case "park" :
                    parking.parkVehicle(new Vehicle(values[1], values[2]));
                    break;
                case "leave":
                    parking.removeVehicle(Integer.parseInt(values[1]));
                    break;
                case "status":
                    parking.getStatus();
                    break;
                case "registration_numbers_for_cars_with_colour":
                    parking.getRegistrationNumbersByColor(values[1]);
                    break;
                case "slot_numbers_for_cars_with_colour" :
                    parking.getSlotNumbersByColor(values[1]);
                    break;
                case "slot_number_for_registration_number" :
                    parking.getSlotNoForGivenRegistrationNo(values[1]);
                    break;

            }
        }

    }
}
