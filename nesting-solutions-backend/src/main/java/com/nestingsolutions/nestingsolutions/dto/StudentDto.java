package com.nestingsolutions.nestingsolutions.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StudentDto extends IndividualDto {
    private Character gender;
    private String personalId;
    private Date dateOfBirth;
}
