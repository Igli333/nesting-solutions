package com.nestingsolutions.nestingsolutions.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class IndividualDto {
    private Integer id;
    private String firstName;
    private String surname;
    private String email;
    private String phoneNumber;
    private String address;
}
