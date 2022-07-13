package com.example.parkingLot.service.impl;

import com.example.parkingLot.dto.CreateParkingLotInput;
import com.example.parkingLot.entity.Floor;
import com.example.parkingLot.entity.ParkingLot;
import com.example.parkingLot.enums.InputAction;
import com.example.parkingLot.service.IActionTaker;
import com.example.parkingLot.service.IParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingLotCreator implements IActionTaker<CreateParkingLotInput> {

    private final IParkingLotService parkingLotService;

    @Autowired
    public ParkingLotCreator(IParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @Override
    public String takeAction(CreateParkingLotInput parkingLotCreateInput) {
        ParkingLot parkingLot = ParkingLot.builder()
                .id(parkingLotCreateInput.getParkingLotId())
                .build();

        parkingLot.addFloors(parkingLotCreateInput.getFloors(), parkingLotCreateInput.getSlotsPerFloor());
        parkingLotService.save(parkingLot);
        return "Created Parking Lot with id: " + parkingLot.getId();
    }

    @Override
    public InputAction getInputAction() {
        return InputAction.CREATE_PARKING_LOT;
    }
}
