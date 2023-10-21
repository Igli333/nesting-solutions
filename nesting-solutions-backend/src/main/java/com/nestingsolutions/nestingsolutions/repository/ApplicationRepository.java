package com.nestingsolutions.nestingsolutions.repository;

import com.nestingsolutions.nestingsolutions.entities.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application, Integer> {
}
