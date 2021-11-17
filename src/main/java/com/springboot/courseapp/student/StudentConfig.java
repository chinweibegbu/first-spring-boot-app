package com.springboot.courseapp.student;

import java.time.*;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			Student ayoola = new Student(
					"Ayoola Falugba", 
					"ayofal@gmail.com",
					LocalDate.of(2000, Month.FEBRUARY, 14)
			);
			Student omone = new Student(
					"Omone Oshiafi",
					"oshiafi1923@loyolajesuit.org",
					LocalDate.of(1983, Month.JUNE, 16)
			);
			
			repository.saveAll(List.of(ayoola, omone));
		};
	}
}
