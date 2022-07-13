package com.example.parkingLot.service.impl;

import com.example.parkingLot.dto.CommandLineInputMarker;
import com.example.parkingLot.dto.DisplayInput;
import com.example.parkingLot.enums.DisplayType;
import com.example.parkingLot.enums.InputAction;
import com.example.parkingLot.enums.VehicleType;
import com.example.parkingLot.service.IInputCreator;
import org.springframework.stereotype.Service;

@Service
public class DisplayInputCreator implements IInputCreator {

    @Override
    public CommandLineInputMarker createInput(String[] input) {
        return DisplayInput.builder()
                .displayType(DisplayType.getDisplayType(input[0]))
                .vehicleType(VehicleType.getVehicleType(input[1]))
                .build();
    }

    @Override
    public InputAction getInputAction() {
        return InputAction.DISPLAY;
    }
}
