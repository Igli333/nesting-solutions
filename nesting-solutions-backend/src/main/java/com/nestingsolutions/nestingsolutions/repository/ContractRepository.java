package com.nestingsolutions.nestingsolutions.repository;

import com.nestingsolutions.nestingsolutions.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
