package com.nestingsolutions.nestingsolutions.service.impl;

import com.nestingsolutions.nestingsolutions.config.Mapper;
import com.nestingsolutions.nestingsolutions.dto.ContractDto;
import com.nestingsolutions.nestingsolutions.entities.Application;
import com.nestingsolutions.nestingsolutions.entities.Contract;
import com.nestingsolutions.nestingsolutions.entities.Room;
import com.nestingsolutions.nestingsolutions.entities.Student;
import com.nestingsolutions.nestingsolutions.enums.PaymentType;
import com.nestingsolutions.nestingsolutions.enums.RoomStatus;
import com.nestingsolutions.nestingsolutions.repository.ContractRepository;
import com.nestingsolutions.nestingsolutions.repository.RoomRepository;
import com.nestingsolutions.nestingsolutions.repository.StudentRepository;
import com.nestingsolutions.nestingsolutions.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final RoomRepository roomRepository;
    private final StudentRepository studentRepository;
    private final Mapper mapper;

    @Override
    public void generateContract(List<Application> applications) {
        Contract contract = new Contract();

        Room emptyRoom = roomRepository.findByStatusAndRoomType(RoomStatus.FREE, applications.get(0).getRoomType());
        contract.setRoom(emptyRoom);

        emptyRoom.setStatus(RoomStatus.OCCUPIED);
        roomRepository.save(emptyRoom);

        contract.setStudents(applications.stream().map(Application::getStudent).collect(Collectors.toSet()));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        Date firstDayOfNextMonth = calendar.getTime();
        contract.setDateOfStart(firstDayOfNextMonth);
        calendar.add(Calendar.YEAR, 1);

        contract.setDateOfFinish(calendar.getTime());
        contract.setPaymentType(PaymentType.BANK);

        contractRepository.save(contract);
    }

    @Override
    public ContractDto getContract(Long id) {
        Contract contract = null;
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();

            contract = student.getContract();
        }

        return mapper.map(contract, ContractDto.class);
    }

    @Override
    public List<ContractDto> findAll() {
        return mapper.map(contractRepository.findAll(), ContractDto.class);
    }

    @Override
    public List<ContractDto> findContractsSignedLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date result = cal.getTime();
        return mapper.map(contractRepository.findAllByDateOfStartAfter(result), ContractDto.class);
    }
}
