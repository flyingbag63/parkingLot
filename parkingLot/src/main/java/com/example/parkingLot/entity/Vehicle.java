package com.example.parkingLot.entity;

import com.example.parkingLot.enums.SlotStatus;
import com.example.parkingLot.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Integer ticketId;

    private VehicleType vehicleType;

    private String registrationNo;

    private String color;

}
