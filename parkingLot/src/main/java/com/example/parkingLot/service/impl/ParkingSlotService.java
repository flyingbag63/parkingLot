package com.example.parkingLot.service.impl;

import com.example.parkingLot.entity.ParkingSlot;
import com.example.parkingLot.enums.SlotStatus;
import com.example.parkingLot.enums.VehicleType;
import com.example.parkingLot.repository.ParkingSlotRepository;
import com.example.parkingLot.service.IParkingSlotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ParkingSlotService implements IParkingSlotService {

    private final ParkingSlotRepository parkingSlotRepository;

    @Autowired
    public ParkingSlotService(ParkingSlotRepository parkingSlotRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
    }


    @Override
    public ParkingSlot getFirstAvailableSlot(VehicleType vehicleType) {
        return parkingSlotRepository.findFirstByVehicleTypeAndSlotStatus(vehicleType, SlotStatus.UNPARKED);
    }

    @Override
    public ParkingSlot save(ParkingSlot parkingSlot) {
        return parkingSlotRepository.save(parkingSlot);
    }
}
