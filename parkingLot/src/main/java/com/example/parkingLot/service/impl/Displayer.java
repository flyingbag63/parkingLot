package com.example.parkingLot.service.impl;

import com.example.parkingLot.dto.DisplayInput;
import com.example.parkingLot.entity.Floor;
import com.example.parkingLot.entity.ParkingLot;
import com.example.parkingLot.entity.ParkingSlot;
import com.example.parkingLot.enums.InputAction;
import com.example.parkingLot.enums.SlotStatus;
import com.example.parkingLot.enums.VehicleType;
import com.example.parkingLot.service.IActionTaker;
import com.example.parkingLot.service.IParkingLotService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class Displayer implements IActionTaker<DisplayInput> {

    private final IParkingLotService parkingLotService;

    @Autowired
    public Displayer(IParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @Override
    public String takeAction(DisplayInput displayInput) {
        ParkingLot parkingLot = parkingLotService.getFirstParkingLot();
        List<Floor> floorList = parkingLot.getFloors();
        switch (displayInput.getDisplayType()) {
            case FREE_COUNT:
                return getFreeCount(floorList, displayInput.getVehicleType());
            case FREE_SLOTS:
                return getFreeSlots(floorList, displayInput.getVehicleType());
            case OCCUPIED_SLOTS:
                return getOccupiedSlots(floorList, displayInput.getVehicleType());
        }

        return "Invalid Input";
    }

    private String getOccupiedSlots(List<Floor> floorList, VehicleType vehicleType) {
        StringBuilder stringBuilder = new StringBuilder();
        floorList.forEach(floor -> {
            List<ParkingSlot> slots = floor.getParkingSlots().stream()
                    .filter(parkingSlot -> Objects.equals(vehicleType, parkingSlot.getVehicleType()) &&
                            Objects.equals(SlotStatus.PARKED, parkingSlot.getSlotStatus()))
                    .collect(Collectors.toList());
            stringBuilder.append("Occupied slots for ")
                    .append(vehicleType)
                    .append(" on Floor ")
                    .append(floor.getFloorIndex())
                    .append(": ")
                    .append(StringUtils.join(", ", slots.stream().map(ParkingSlot::getSlotNo).collect(Collectors.toList())))
                    .append("\n");
        });

        return stringBuilder.toString();
    }

    private String getFreeSlots(List<Floor> floorList, VehicleType vehicleType) {
        StringBuilder stringBuilder = new StringBuilder();
        floorList.forEach(floor -> {
            List<ParkingSlot> slots = floor.getParkingSlots().stream()
                    .filter(parkingSlot -> Objects.equals(vehicleType, parkingSlot.getVehicleType()) &&
                            Objects.equals(SlotStatus.UNPARKED, parkingSlot.getSlotStatus()))
                    .collect(Collectors.toList());
            stringBuilder.append("Free slots for ")
                    .append(vehicleType)
                    .append(" on Floor ")
                    .append(floor.getFloorIndex())
                    .append(": ")
                    .append(StringUtils.join(", ", slots.stream().map(ParkingSlot::getSlotNo).collect(Collectors.toList())))
                    .append("\n");
        });

        return stringBuilder.toString();
    }

    private String getFreeCount(List<Floor> floorList, VehicleType vehicleType) {
        StringBuilder stringBuilder = new StringBuilder();
        floorList.forEach(floor -> {
            Integer freeSlots = Math.toIntExact(floor.getParkingSlots().stream()
                    .filter(parkingSlot -> Objects.equals(vehicleType, parkingSlot.getVehicleType()) &&
                            Objects.equals(SlotStatus.UNPARKED, parkingSlot.getSlotStatus()))
                    .count());
            stringBuilder.append("No of free slots for ")
                    .append(vehicleType)
                    .append(" on Floor ")
                    .append(floor.getFloorIndex())
                    .append(": ")
                    .append(freeSlots)
                    .append("\n");
        });

        return stringBuilder.toString();
    }

    @Override
    public InputAction getInputAction() {
        return InputAction.DISPLAY;
    }
}
