package com.example.parkingLot.entity;

import com.example.parkingLot.enums.SlotStatus;
import com.example.parkingLot.enums.VehicleType;
import lombok.*;

import javax.persistence.*;

@Data
@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Integer slotNo;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "floorId", nullable = false)
    @ToString.Exclude
    private Floor floor;

    @Builder.Default
    private SlotStatus slotStatus = SlotStatus.UNPARKED;

    private VehicleType vehicleType;
}
