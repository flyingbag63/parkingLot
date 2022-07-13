package com.example.parkingLot.service.impl;

import com.example.parkingLot.dto.CommandLineInputMarker;
import com.example.parkingLot.dto.UnparkVehicleInput;
import com.example.parkingLot.enums.InputAction;
import com.example.parkingLot.service.IInputCreator;
import org.springframework.stereotype.Service;

@Service
public class UnparkVehicleInputCreator implements IInputCreator {

    @Override
    public CommandLineInputMarker createInput(String[] input) {
        return UnparkVehicleInput.builder()
                .ticketId(input[0])
                .build();
    }

    @Override
    public InputAction getInputAction() {
        return InputAction.UNPARK_VEHICLE;
    }
}
