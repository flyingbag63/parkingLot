package com.example.parkingLot.dto;

import com.example.parkingLot.enums.DisplayType;
import com.example.parkingLot.enums.VehicleType;

public class DisplayInput implements CommandLineInputMarker {

    private DisplayType displayType;
    private VehicleType vehicleType;

    public DisplayInput(DisplayType displayType, VehicleType vehicleType) {
        this.displayType = displayType;
        this.vehicleType = vehicleType;
    }

    public DisplayType getDisplayType() {
        return displayType;
    }
}
