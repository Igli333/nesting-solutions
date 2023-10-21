package com.nestingsolutions.nestingsolutions.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class RoomTypeDto {
    private Integer id;
    private String category;
    private Integer capacity;
}
