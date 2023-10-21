package com.nestingsolutions.nestingsolutions.controller;

import com.nestingsolutions.nestingsolutions.dto.ContractDto;
import com.nestingsolutions.nestingsolutions.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contract")
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;

    @GetMapping("/{userId}")
    public ResponseEntity<ContractDto> getContractOfStudent(@PathVariable("userId") Long id) {
        return ResponseEntity.ok(contractService.getContract(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ContractDto>> getAllContracts() {
        return ResponseEntity.ok(contractService.findAll());
    }

    @GetMapping("/new")
    public ResponseEntity<List<ContractDto>> getAllContractsSignedLastMonth() {
        return ResponseEntity.ok(contractService.findContractsSignedLastMonth());
    }
}
