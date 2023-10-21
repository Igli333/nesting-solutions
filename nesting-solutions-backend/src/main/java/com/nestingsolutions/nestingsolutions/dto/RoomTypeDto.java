package com.nestingsolutions.nestingsolutions.dto;

import lombok.Data;

@Data
public class RoomTypeDto {
    private Long id;
    private String category;
    private Integer capacity;
    private Double price;
}
