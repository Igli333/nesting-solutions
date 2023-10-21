package com.nestingsolutions.nestingsolutions.dto;

import lombok.Data;

@Data
public class IndividualDto {
    private Long id;
    private String firstName;
    private String surname;
    private String email;
    private String phoneNumber;
    private String address;
}
