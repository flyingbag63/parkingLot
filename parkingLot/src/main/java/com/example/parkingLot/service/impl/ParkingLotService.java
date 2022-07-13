package com.example.parkingLot.service.impl;

import com.example.parkingLot.entity.ParkingLot;
import com.example.parkingLot.repository.ParkingLotRepository;
import com.example.parkingLot.service.IParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService implements IParkingLotService {

    private final ParkingLotRepository parkingLotRepository;

    @Autowired
    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public ParkingLot save(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    @Override
    public ParkingLot getFirstParkingLot() {
        return parkingLotRepository.findAll().stream().findFirst().get();
    }
}
