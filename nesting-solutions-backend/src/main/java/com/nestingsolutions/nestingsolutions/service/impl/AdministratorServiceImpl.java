package com.nestingsolutions.nestingsolutions.service.impl;

import com.nestingsolutions.nestingsolutions.dto.security.AdminRegistrationRequest;
import com.nestingsolutions.nestingsolutions.entities.Administrator;
import com.nestingsolutions.nestingsolutions.repository.AdministratorRepository;
import com.nestingsolutions.nestingsolutions.security.PasswordConfig;
import com.nestingsolutions.nestingsolutions.service.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdministratorServiceImpl implements AdministratorService {

    private final PasswordConfig passwordConfig;
    private final AdministratorRepository administratorRepository;

    public String addAdmin(AdminRegistrationRequest adminInfo) {
        Administrator newAdmin = new Administrator();
        newAdmin.setFirstName(adminInfo.getFirstName());
        newAdmin.setSurname(adminInfo.getSurname());
        newAdmin.setEmail(adminInfo.getEmail());
        newAdmin.setPhoneNumber(adminInfo.getPhoneNumber());
        newAdmin.setPassword(passwordConfig.passwordEncoder().encode(adminInfo.getPassword()));
        administratorRepository.save(newAdmin);
        return "User added to system with email: "+adminInfo.getEmail();
    }
}
