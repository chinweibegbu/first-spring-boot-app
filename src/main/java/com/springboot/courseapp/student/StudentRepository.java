package com.springboot.courseapp.student;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface StudentRepository 
		extends JpaRepository<Student, Long> {

	// Method to get a Student by Email >> How does Spring Boot know how to do this?
	Optional<Student> getStudentByEmail(String email);
}
