package com.nestingsolutions.nestingsolutions.service;

import com.nestingsolutions.nestingsolutions.dto.ApplicationDto;

import java.util.List;

public interface ApplicationService {
    List<ApplicationDto> getOnHoldApplications();

    ApplicationDto update(ApplicationDto applicationRequest);

    ApplicationDto approve(Integer id);

    void reject(Integer id);
}
