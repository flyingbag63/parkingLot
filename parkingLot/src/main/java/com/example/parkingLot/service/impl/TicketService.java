package com.example.parkingLot.service.impl;

import com.example.parkingLot.dto.ParkVehicleInput;
import com.example.parkingLot.entity.ParkingSlot;
import com.example.parkingLot.entity.Ticket;
import com.example.parkingLot.enums.TicketStatus;
import com.example.parkingLot.repository.TicketRepository;
import com.example.parkingLot.service.ITicketService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Stream;

@Service
public class TicketService implements ITicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket createTicket(ParkingSlot parkingSlot, ParkVehicleInput parkVehicleInput) {
        String ticketId = getTicketId(parkingSlot);
        Ticket ticket = Ticket.builder()
                .ticketId(ticketId)
                .parkingSlot(parkingSlot)
                .vehicleRegistrationNo(parkVehicleInput.getRegistrationNo())
                .build();

        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicket(String ticketId) {
        return ticketRepository.findByTicketIdAndTicketStatus(ticketId, TicketStatus.ACTIVE);
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    private String getTicketId(ParkingSlot parkingSlot) {
        return StringUtils.join(Stream.of(parkingSlot.getFloor().getParkingLot().getId(),
                        parkingSlot.getFloor().getFloorIndex(),
                        parkingSlot.getSlotNo())
                .toArray(Object[]::new), "_");
    }
}
