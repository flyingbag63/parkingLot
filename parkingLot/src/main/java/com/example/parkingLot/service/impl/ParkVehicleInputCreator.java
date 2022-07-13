package com.example.parkingLot.service.impl;

import com.example.parkingLot.dto.CommandLineInputMarker;
import com.example.parkingLot.dto.ParkVehicleInput;
import com.example.parkingLot.enums.InputAction;
import com.example.parkingLot.enums.VehicleType;
import com.example.parkingLot.service.IInputCreator;
import org.springframework.stereotype.Service;

@Service
public class ParkVehicleInputCreator implements IInputCreator {

    @Override
    public CommandLineInputMarker createInput(String[] input) {
        return ParkVehicleInput.builder()
                .vehicleType(VehicleType.getVehicleType(input[0]))
                .registrationNo(input[1])
                .color(input[2])
                .build();
    }

    @Override
    public InputAction getInputAction() {
        return InputAction.PARK_VEHICLE;
    }
}
