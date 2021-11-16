package com.springboot.courseapp.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/students")
public class StudentController {

	@GetMapping
	public List<Student> getAllStudents() {
		return List.of(
				new Student(1L, "Ayoola Falugba", "ayofal@gmail.com", LocalDate.of(2000, Month.FEBRUARY, 14), 20),
				new Student(1L, "Omone Oshiafi", "oshiafi1923@loyolajesuit.org", LocalDate.of(1983, Month.JUNE, 16), 30));
	}
}
