package com.nestingsolutions.nestingsolutions.dto;

import com.nestingsolutions.nestingsolutions.enums.Floor;
import com.nestingsolutions.nestingsolutions.enums.RoomStatus;
import lombok.Data;

@Data
public class RoomDto {
    private Long id;
    private String roomNumber;
    private RoomStatus status;
    private Floor floor;
}
