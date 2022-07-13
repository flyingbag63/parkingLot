package com.example.parkingLot.enums;

import com.example.parkingLot.dto.DisplayInput;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DisplayType {

    FREE_COUNT,
    FREE_SLOTS,
    OCCUPIED_SLOTS;

    public static DisplayType getDisplayType(String displayType) {
        for (DisplayType displayType1 : DisplayType.values()) {
            if (displayType1.toString().equalsIgnoreCase(displayType)) {
                return displayType1;
            }
        }

        return null;
    }

}
