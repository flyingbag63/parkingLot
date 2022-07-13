package com.example.parkingLot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InputAction {

    CREATE_PARKING_LOT("Create Parking Lot"),
    PARK_VEHICLE("Park Vehicle"),
    UNPARK_VEHICLE("UnPark Vehicle"),
    DISPLAY("Display");

    private String name;

    public static InputAction getInputAction(String inputAction) {
        for (InputAction inputAction1 : values()) {
            if (inputAction1.toString().equalsIgnoreCase(inputAction)) {
                return inputAction1;
            }
        }

        return null;
    }
}
