package com.nestingsolutions.nestingsolutions.service.impl;

import com.nestingsolutions.nestingsolutions.entities.Application;
import com.nestingsolutions.nestingsolutions.entities.Contract;
import com.nestingsolutions.nestingsolutions.entities.Room;
import com.nestingsolutions.nestingsolutions.enums.PaymentType;
import com.nestingsolutions.nestingsolutions.enums.RoomStatus;
import com.nestingsolutions.nestingsolutions.repository.ContractRepository;
import com.nestingsolutions.nestingsolutions.repository.RoomRepository;
import com.nestingsolutions.nestingsolutions.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;
    private final RoomRepository roomRepository;

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
}
