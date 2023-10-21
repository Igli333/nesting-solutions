package com.nestingsolutions.nestingsolutions.repository;

import com.nestingsolutions.nestingsolutions.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
