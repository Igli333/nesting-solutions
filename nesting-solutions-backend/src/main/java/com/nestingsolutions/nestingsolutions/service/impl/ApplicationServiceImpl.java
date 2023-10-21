package com.nestingsolutions.nestingsolutions.service.impl;

import com.nestingsolutions.nestingsolutions.config.Mapper;
import com.nestingsolutions.nestingsolutions.dto.ApplicationDto;
import com.nestingsolutions.nestingsolutions.entities.Application;
import com.nestingsolutions.nestingsolutions.entities.RoomType;
import com.nestingsolutions.nestingsolutions.enums.ApplicationStatus;
import com.nestingsolutions.nestingsolutions.repository.ApplicationRepository;
import com.nestingsolutions.nestingsolutions.service.ApplicationService;
import com.nestingsolutions.nestingsolutions.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ContractService contractService;
    private final Mapper mapper;

    @Override
    public List<ApplicationDto> getOnHoldApplications() {
        return mapper.map(
                applicationRepository
                        .findAllByStatus(ApplicationStatus.ON_HOLD),
                ApplicationDto.class);
    }

    @Override
    public ApplicationDto update(ApplicationDto applicationRequest) {
        Application application = mapper.map(applicationRequest, Application.class);
        return mapper.map(applicationRepository.save(application), ApplicationDto.class);
    }

    @Override
    public ApplicationDto approve(Integer id) {
        Application application;
        Optional<Application> applicationOptional = applicationRepository.findById(id);

        if (applicationOptional.isPresent()) {
            application = applicationOptional.get();
            RoomType roomType = application.getRoomType();

            List<Application> pending = null;

            List<Application> pendingByCode = applicationRepository.findAllByCodeAndStatus(application.getCode(), ApplicationStatus.PENDING_APPROVED);

            if (!pendingByCode.isEmpty()) {
                pending = pendingByCode;
            } else {
                pending = applicationRepository.findAllByStatusAndRoomType(ApplicationStatus.PENDING_APPROVED, roomType);
            }

            if (pending.size() + 1 == roomType.getCapacity()) {
                pending.add(application);
                pending.forEach(a -> a.setStatus(ApplicationStatus.APPROVED));

                contractService.generateContract(pending);

                applicationRepository.deleteAllByStudentAndStatus(application.getStudent(), ApplicationStatus.ON_HOLD);
            } else {
                application.setStatus(ApplicationStatus.PENDING_APPROVED);
            }
        } else {
            return null;
        }

        return mapper.map(applicationRepository.save(application), ApplicationDto.class);
    }

    @Override
    public void reject(Integer id) {
        applicationRepository.deleteById(id);
    }

}
