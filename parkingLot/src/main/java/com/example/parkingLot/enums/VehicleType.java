package com.example.parkingLot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VehicleType {

    CAR("Car"),
    BIKE("Bike"),
    TRUCK("Truck");

    private String name;

    public static VehicleType getVehicleType(String vehicleType) {
        for (VehicleType vehicleType1 : values()) {
            if (vehicleType1.toString().equalsIgnoreCase(vehicleType)) {
                return vehicleType1;
            }
        }

        return null;
    }
}
