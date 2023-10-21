package com.nestingsolutions.nestingsolutions.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ContractDto {
    private Long id;
    private Integer paymentType;
    private Date dateOfStart;
    private Date dateOfFinish;
    private Integer type;
    private Boolean status;
    private Integer student;
    private Integer room;
}
