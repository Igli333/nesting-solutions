package com.nestingsolutions.nestingsolutions;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories("com.nestingsolutions.nestingsolutions.repository")
public class NestingSolutionsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(NestingSolutionsBackendApplication.class, args);
	}


	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
