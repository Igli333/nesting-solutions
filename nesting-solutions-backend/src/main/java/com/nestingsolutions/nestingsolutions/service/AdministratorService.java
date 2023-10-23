package com.nestingsolutions.nestingsolutions.service;

import com.nestingsolutions.nestingsolutions.dto.AdministratorDto;
import com.nestingsolutions.nestingsolutions.dto.security.AdminRegistrationRequest;
import jakarta.servlet.http.HttpServletRequest;

public interface AdministratorService {
    String addAdmin(AdminRegistrationRequest adminInfo);
    AdministratorDto adminProfile(HttpServletRequest request);
}
