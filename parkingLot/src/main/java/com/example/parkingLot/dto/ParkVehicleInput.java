package com.example.parkingLot.dto;

import com.example.parkingLot.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkVehicleInput implements CommandLineInputMarker {

    private VehicleType vehicleType;
    private String registrationNo;
    private String color;
}
