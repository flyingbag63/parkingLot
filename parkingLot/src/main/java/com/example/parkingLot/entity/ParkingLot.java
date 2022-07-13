package com.example.parkingLot.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLot {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade=CascadeType.ALL)
    @JoinColumn(name = "floorId")
    @ToString.Exclude
    private List<Floor> floors = new ArrayList<>();

    public void addFloors(Integer noOfFloors, Integer slotsPerFloor) {
        if (Objects.isNull(floors)) {
            floors = new ArrayList<>();
        }
        for (Integer floorIndex = 1; floorIndex <= noOfFloors; floorIndex++) {
            Floor floor = Floor.builder()
                    .floorIndex(floorIndex)
                    .parkingLot(this)
                    .build();

            floor.addParkingSlots(slotsPerFloor);
            floors.add(floor);
        }
    }
}
