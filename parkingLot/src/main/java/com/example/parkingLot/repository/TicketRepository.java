package com.example.parkingLot.repository;

import com.example.parkingLot.entity.Ticket;
import com.example.parkingLot.enums.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    Ticket findByTicketIdAndTicketStatus(String registrationNo, TicketStatus ticketStatus);
}
