package com.nestingsolutions.nestingsolutions.controller;

import com.nestingsolutions.nestingsolutions.dto.security.AdminRegistrationRequest;
import com.nestingsolutions.nestingsolutions.dto.security.AdminRegistrationResponse;
import com.nestingsolutions.nestingsolutions.dto.security.AuthRequest;
import com.nestingsolutions.nestingsolutions.dto.security.AuthResponse;
import com.nestingsolutions.nestingsolutions.security.service.JwtService;
import com.nestingsolutions.nestingsolutions.service.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdministratorController {
    private final JwtService jwtService;
    private final AdministratorService adminService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/")
    public ResponseEntity<AdminRegistrationResponse> addNewAdmin(@RequestBody AdminRegistrationRequest userInfo) {
        return new ResponseEntity<>(new AdminRegistrationResponse(adminService.addAdmin(userInfo)), HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return new ResponseEntity<>(new AuthResponse(authRequest.getEmail(), jwtService.generateToken(authRequest.getEmail())), HttpStatus.OK);
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
