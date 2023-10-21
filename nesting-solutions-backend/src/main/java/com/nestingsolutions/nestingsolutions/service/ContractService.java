package com.nestingsolutions.nestingsolutions.service;

import com.nestingsolutions.nestingsolutions.entities.Application;

import java.util.List;

public interface ContractService {
    void generateContract(List<Application> applications);
}
