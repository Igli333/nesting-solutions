package com.nestingsolutions.nestingsolutions.dto.security;

import lombok.Data;

@Data
public class AdminRegistrationRequest {
    private String firstName;
    private String surname;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
}
