package com.example.parkingLot.entity;

import com.example.parkingLot.entity.Floor;
import com.example.parkingLot.entity.ParkingLot;
import com.example.parkingLot.entity.ParkingSlot;
import com.example.parkingLot.enums.TicketStatus;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String ticketId;

    @ManyToOne
    @JoinColumn(name = "parking_slot_id")
    private ParkingSlot parkingSlot;

    private String vehicleRegistrationNo;

    @Builder.Default
    private TicketStatus ticketStatus = TicketStatus.ACTIVE;
}
