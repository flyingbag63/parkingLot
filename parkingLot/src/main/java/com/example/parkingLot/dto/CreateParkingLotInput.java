package com.example.parkingLot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateParkingLotInput implements CommandLineInputMarker {

    private String parkingLotId;
    private Integer floors;
    private Integer slotsPerFloor;

}
