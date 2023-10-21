package com.nestingsolutions.nestingsolutions.repository;

import com.nestingsolutions.nestingsolutions.entities.Application;
import com.nestingsolutions.nestingsolutions.entities.RoomType;
import com.nestingsolutions.nestingsolutions.entities.Student;
import com.nestingsolutions.nestingsolutions.enums.ApplicationStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApplicationRepository extends CrudRepository<Application, Integer> {
    List<Application> findAllByStatus(ApplicationStatus status);

    void deleteAllByStudentAndStatus(Student student, ApplicationStatus status);

    List<Application> findAllByStatusAndRoomType(ApplicationStatus status, RoomType roomType);

    List<Application> findAllByCodeAndStatus(String code, ApplicationStatus status);
}
