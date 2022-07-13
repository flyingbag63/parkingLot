package com.example.parkingLot.repository;

import com.example.parkingLot.entity.ParkingSlot;
import com.example.parkingLot.enums.SlotStatus;
import com.example.parkingLot.enums.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Integer> {

    ParkingSlot findFirstByVehicleTypeAndSlotStatus(VehicleType vehicleType, SlotStatus slotStatus);
}
