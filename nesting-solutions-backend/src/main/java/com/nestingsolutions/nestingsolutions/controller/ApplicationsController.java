package com.nestingsolutions.nestingsolutions.controller;

import com.nestingsolutions.nestingsolutions.dto.ApplicationDto;
import com.nestingsolutions.nestingsolutions.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationsController {
    private final ApplicationService applicationService;

    @GetMapping("/all")
    public ResponseEntity<List<ApplicationDto>> getOnHoldApplications() {
        return ResponseEntity.ok(applicationService.getOnHoldApplications());
    }

    @PostMapping("/approve")
    public ResponseEntity<ApplicationDto> approveApplication(@RequestParam("id") Long id) {
        return ResponseEntity.ok(applicationService.approve(id));
    }

    @PostMapping("/reject")
    public ResponseEntity<?> rejectApplication(@RequestParam("id") Long id) {
        applicationService.reject(id);
        return (ResponseEntity<?>) ResponseEntity.ok();
    }
}
