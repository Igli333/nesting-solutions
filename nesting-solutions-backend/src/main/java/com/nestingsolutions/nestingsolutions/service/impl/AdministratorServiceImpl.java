package com.nestingsolutions.nestingsolutions.service.impl;

import com.nestingsolutions.nestingsolutions.config.Mapper;
import com.nestingsolutions.nestingsolutions.dto.AdministratorDto;
import com.nestingsolutions.nestingsolutions.dto.security.AdminRegistrationRequest;
import com.nestingsolutions.nestingsolutions.entities.Administrator;
import com.nestingsolutions.nestingsolutions.repository.AdministratorRepository;
import com.nestingsolutions.nestingsolutions.security.PasswordConfig;
import com.nestingsolutions.nestingsolutions.security.service.JwtService;
import com.nestingsolutions.nestingsolutions.service.AdministratorService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdministratorServiceImpl implements AdministratorService {

    private final PasswordConfig passwordConfig;
    private final AdministratorRepository administratorRepository;
    private final Mapper mapper;
    private final JwtService jwtService;

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

    public AdministratorDto adminProfile(HttpServletRequest request){

        String authHeader = request.getHeader("Authorization");
        String token = null;
        String adminEmail = null;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            adminEmail = jwtService.extractUsername(token);
        }

        Administrator administrator = null;
        Optional<Administrator> adminData = administratorRepository.findByEmail(adminEmail);
        if(adminData.isPresent()){
            administrator = adminData.get();
        }
        return mapper.map(administrator, AdministratorDto.class);
    }
}
