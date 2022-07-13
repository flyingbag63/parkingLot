package com.example.parkingLot.service.impl;

import com.example.parkingLot.dto.UnparkVehicleInput;
import com.example.parkingLot.entity.ParkingSlot;
import com.example.parkingLot.entity.Ticket;
import com.example.parkingLot.enums.InputAction;
import com.example.parkingLot.enums.SlotStatus;
import com.example.parkingLot.enums.TicketStatus;
import com.example.parkingLot.service.IActionTaker;
import com.example.parkingLot.service.IParkingSlotService;
import com.example.parkingLot.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class VehicleUnparker implements IActionTaker<UnparkVehicleInput> {

    private final ITicketService ticketService;
    private final IParkingSlotService parkingSlotService;

    @Autowired
    public VehicleUnparker(ITicketService ticketService, IParkingSlotService parkingSlotService) {
        this.ticketService = ticketService;
        this.parkingSlotService = parkingSlotService;
    }


    @Override
    public String takeAction(UnparkVehicleInput unparkVehicleInput) {
        Ticket ticket = ticketService.getTicket(unparkVehicleInput.getTicketId());
        if (Objects.isNull(ticket)) {
            return "No Ticket found with id: " + unparkVehicleInput.getTicketId();
        }

        ParkingSlot parkingSlot = ticket.getParkingSlot();
        parkingSlot.setSlotStatus(SlotStatus.UNPARKED);
        parkingSlotService.save(parkingSlot);
        ticket.setTicketStatus(TicketStatus.INACTIVE);
        ticketService.save(ticket);
        return "Un parked Vehicle with ticket id: " + unparkVehicleInput.getTicketId();
    }

    @Override
    public InputAction getInputAction() {
        return InputAction.UNPARK_VEHICLE;
    }
}
