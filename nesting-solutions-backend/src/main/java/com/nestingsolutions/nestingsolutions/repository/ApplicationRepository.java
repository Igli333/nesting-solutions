package com.nestingsolutions.nestingsolutions.repository;

import com.nestingsolutions.nestingsolutions.entities.Application;
import com.nestingsolutions.nestingsolutions.entities.RoomType;
import com.nestingsolutions.nestingsolutions.entities.Student;
import com.nestingsolutions.nestingsolutions.enums.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findAllByStatus(ApplicationStatus status);

    void deleteAllByStudentAndStatus(Student student, ApplicationStatus status);

    List<Application> findAllByStatusAndRoomTypeAndStudent_Gender(ApplicationStatus status, RoomType roomType, Character gender);

    List<Application> findAllByCodeAndStatus(String code, ApplicationStatus status);
}
