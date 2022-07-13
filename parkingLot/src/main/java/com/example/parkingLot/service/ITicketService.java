package com.example.parkingLot.service;

import com.example.parkingLot.dto.ParkVehicleInput;
import com.example.parkingLot.entity.ParkingSlot;
import com.example.parkingLot.entity.Ticket;

public interface ITicketService {

    Ticket createTicket(ParkingSlot parkingSlot, ParkVehicleInput parkVehicleInput);

    Ticket getTicket(String ticketId);

    Ticket save(Ticket ticket);
}
