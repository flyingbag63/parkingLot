package com.example.parkingLot.service;

import com.example.parkingLot.dto.CommandLineInputMarker;
import com.example.parkingLot.enums.InputAction;

public interface IInputCreator {

    CommandLineInputMarker createInput(String[] input);

    InputAction getInputAction();
}
