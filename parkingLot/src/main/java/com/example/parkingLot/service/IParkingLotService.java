package com.example.parkingLot.service;

import com.example.parkingLot.entity.ParkingLot;

public interface IParkingLotService {

    ParkingLot save(ParkingLot parkingLot);

    ParkingLot getFirstParkingLot();
}
