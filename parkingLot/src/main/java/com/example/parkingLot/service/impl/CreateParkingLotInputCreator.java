package com.example.parkingLot.service.impl;

import com.example.parkingLot.dto.CommandLineInputMarker;
import com.example.parkingLot.dto.CreateParkingLotInput;
import com.example.parkingLot.enums.InputAction;
import com.example.parkingLot.service.IInputCreator;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

@Service
public class CreateParkingLotInputCreator implements IInputCreator {

    @Override
    public CommandLineInputMarker createInput(String[] input) {
        return CreateParkingLotInput.builder()
                .parkingLotId(input[0])
                .floors(NumberUtils.parseNumber(input[1], Integer.class))
                .slotsPerFloor(NumberUtils.parseNumber(input[2], Integer.class))
                .build();
    }

    @Override
    public InputAction getInputAction() {
        return InputAction.CREATE_PARKING_LOT;
    }
}
