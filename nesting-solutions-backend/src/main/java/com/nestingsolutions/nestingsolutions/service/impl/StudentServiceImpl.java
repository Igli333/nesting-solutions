package com.nestingsolutions.nestingsolutions.service.impl;

import com.nestingsolutions.nestingsolutions.config.Mapper;
import com.nestingsolutions.nestingsolutions.dto.StudentDto;
import com.nestingsolutions.nestingsolutions.entities.Student;
import com.nestingsolutions.nestingsolutions.repository.StudentRepository;
import com.nestingsolutions.nestingsolutions.service.ContractService;
import com.nestingsolutions.nestingsolutions.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final Mapper mapper;

    @Override
    public List<StudentDto> findAll() {
        return mapper.map(studentRepository.findAll(), StudentDto.class);
    }

    @Override
    public List<StudentDto> findAllWithValidContracts() {
        return mapper.map(studentRepository.findAllByContract_Status(true), StudentDto.class);
    }

    @Override
    public StudentDto getStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.map(student -> mapper.map(student, StudentDto.class)).orElse(null);
    }

    @Override
    public void clearMonthlyPayment() {
        studentRepository.updatePaidThisMonth(false);
    }

    @Override
    public StudentDto createStudent(StudentDto studentRequest) {
        Student student = mapper.map(studentRequest, Student.class);
        return mapper.map(studentRepository.save(student), StudentDto.class);
    }

    @Override
    public List<StudentDto> findStudentsCloseToTermination() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        Date result = cal.getTime();
        return mapper.map(studentRepository.findAllByContract_DateOfFinishBefore(result), StudentDto.class);
    }
}
