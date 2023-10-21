package com.nestingsolutions.nestingsolutions.service;

import com.nestingsolutions.nestingsolutions.dto.security.AdminRegistrationRequest;

public interface AdministratorService {
    public String addAdmin(AdminRegistrationRequest adminInfo);
}
