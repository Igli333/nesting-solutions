package com.nestingsolutions.nestingsolutions.service;

import com.nestingsolutions.nestingsolutions.dto.StudentDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    List<StudentDto> findAll();

    List<StudentDto> findAllWithValidContracts();

    StudentDto getStudent(Long id);

    void clearMonthlyPayment();

    StudentDto createStudent(StudentDto studentRequest);

    List<StudentDto> findStudentsCloseToTermination();
}
