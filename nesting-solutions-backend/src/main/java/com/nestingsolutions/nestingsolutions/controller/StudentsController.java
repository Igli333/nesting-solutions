package com.nestingsolutions.nestingsolutions.controller;

import com.nestingsolutions.nestingsolutions.dto.StudentDto;
import com.nestingsolutions.nestingsolutions.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentsController {

    private final StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/active")
    public ResponseEntity<List<StudentDto>> getAllStudentsInContractTerms(){
        return ResponseEntity.ok(studentService.findAllWithValidContracts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentInfo(@PathVariable("id") Long id){
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @PostMapping("")
    public ResponseEntity<StudentDto> addNewStudent(@RequestBody StudentDto studentRequest){
        return ResponseEntity.ok(studentService.createStudent(studentRequest));
    }

    @GetMapping("/nearEnd")
    public ResponseEntity<List<StudentDto>> getStudentsThatTerminateThisMonth(){
        return ResponseEntity.ok(studentService.findStudentsCloseToTermination());
    }
}
