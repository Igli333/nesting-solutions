package com.nestingsolutions.nestingsolutions.service;

import com.nestingsolutions.nestingsolutions.dto.ContractDto;
import com.nestingsolutions.nestingsolutions.entities.Application;
import com.nestingsolutions.nestingsolutions.entities.Contract;

import java.util.List;

public interface ContractService {
    void generateContract(List<Application> applications);

    ContractDto getContract(Long id);

    List<ContractDto> findAll();

    List<ContractDto> findContractsSignedLastMonth();
}
