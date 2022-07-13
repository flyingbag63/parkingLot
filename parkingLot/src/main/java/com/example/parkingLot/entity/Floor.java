package com.example.parkingLot.entity;

import com.example.parkingLot.enums.VehicleType;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Integer floorIndex;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "parkingLotId", nullable = false)
    @ToString.Exclude
    private ParkingLot parkingLot;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade=CascadeType.ALL)
    @JoinColumn(name = "parkingSlotId")
    @ToString.Exclude
    private List<ParkingSlot> parkingSlots = new ArrayList<>();

    public void addParkingSlots(Integer noOfSlots) {
        if (Objects.isNull(parkingSlots)) {
            parkingSlots = new ArrayList<>();
        }

        for (Integer slotIndex = 1; slotIndex <= noOfSlots; slotIndex++) {
            ParkingSlot parkingSlot = ParkingSlot.builder()
                    .slotNo(slotIndex)
                    .vehicleType(getVehicleType(slotIndex))
                    .floor(this)
                    .build();

            parkingSlots.add(parkingSlot);
        }
    }

    private VehicleType getVehicleType(Integer slotIndex) {
        if(slotIndex == 1) {
            return VehicleType.TRUCK;
        }
        else if(slotIndex <= 3) {
            return VehicleType.BIKE;
        }
        else {
            return VehicleType.CAR;
        }
    }
}
