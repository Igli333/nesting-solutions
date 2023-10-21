package com.nestingsolutions.nestingsolutions.repository;

import com.nestingsolutions.nestingsolutions.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Optional<Administrator> findByEmail(String email);
}
