package com.example.parkingLot.service.impl;

import com.example.parkingLot.dto.ParkVehicleInput;
import com.example.parkingLot.entity.ParkingSlot;
import com.example.parkingLot.enums.InputAction;
import com.example.parkingLot.entity.Ticket;
import com.example.parkingLot.enums.SlotStatus;
import com.example.parkingLot.service.IActionTaker;
import com.example.parkingLot.service.IParkingSlotService;
import com.example.parkingLot.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class VehicleParker implements IActionTaker<ParkVehicleInput> {

    private final ITicketService ticketService;
    private final IParkingSlotService parkingSlotService;

    @Autowired
    public VehicleParker(ITicketService ticketService, IParkingSlotService parkingSlotService) {
        this.ticketService = ticketService;
        this.parkingSlotService = parkingSlotService;
    }


    @Override
    public String takeAction(ParkVehicleInput parkVehicleInput) {
        ParkingSlot parkingSlot = parkingSlotService.getFirstAvailableSlot(parkVehicleInput.getVehicleType());
        if (Objects.isNull(parkingSlot)) {
            return "No Parking Slot Available for Vehicle of type: " + parkVehicleInput.getVehicleType();
        }
        parkingSlot.setSlotStatus(SlotStatus.PARKED);
        parkingSlotService.save(parkingSlot);
        Ticket ticket = ticketService.createTicket(parkingSlot, parkVehicleInput);
        return "Parked Vehicle with ticket id: " + ticket.getTicketId();
    }

    @Override
    public InputAction getInputAction() {
        return InputAction.PARK_VEHICLE;
    }
}
