package com.testorg.parking.parser;

import com.testorg.parking.commands.*;

import java.util.HashMap;
import java.util.Map;

public class StringCommandParser {

    private static Map<String, Command> stringToCommandMap = new HashMap<String, Command>() {{
        put("park", new ParkCommand());
        put("leave", new RemoveCommand());
        put("status", new StatusCommand());
        put("registration_numbers_for_cars_with_colour", new FindCarRegistrationNumbersByColorCommand());
        put("slot_numbers_for_cars_with_colour", new FindAllocatedSlotsByVehicleColorCommand());
        put("slot_number_for_registration_number", new FindSlotByRegistrationNoCommand());
    }};

    public static Command toCommand(String command) {
        return stringToCommandMap.get(command);
    }
}
