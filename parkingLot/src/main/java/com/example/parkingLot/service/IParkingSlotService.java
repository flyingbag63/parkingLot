package com.example.parkingLot.service;

import com.example.parkingLot.entity.ParkingSlot;
import com.example.parkingLot.enums.VehicleType;

public interface IParkingSlotService {

    ParkingSlot getFirstAvailableSlot(VehicleType vehicleType);

    ParkingSlot save(ParkingSlot parkingSlot);
}
