package com.example.parkingLot.service;

import com.example.parkingLot.enums.InputAction;

public interface IActionTaker<T> {

    String takeAction(T commandLineInputMarker);

    InputAction getInputAction();
}
