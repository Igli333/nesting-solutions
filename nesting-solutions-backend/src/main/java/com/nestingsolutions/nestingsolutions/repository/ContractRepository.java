package com.nestingsolutions.nestingsolutions.repository;

import com.nestingsolutions.nestingsolutions.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findAllByDateOfStartAfter(Date date);
}
