package com.nestingsolutions.nestingsolutions.repository;

import com.nestingsolutions.nestingsolutions.entities.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByContract_Status(Boolean status);

    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.paidThisMonth = :newValue")
    void updatePaidThisMonth(@Param("newValue") boolean newValue);

    List<Student> findAllByContract_DateOfFinishBefore(Date date);
}

