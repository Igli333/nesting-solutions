package com.nestingsolutions.nestingsolutions.dto;

import lombok.Data;

@Data
public class StudentDto extends IndividualDto {
    private Character gender;
    private String personalId;
}
