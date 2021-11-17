package com.springboot.courseapp.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student) {
		// If the email address exists in the DB, throw an error
		Optional<Student> studentWithEmail = studentRepository.getStudentByEmail(student.getEmail());
		
		if(studentWithEmail.isPresent()) {
			throw new IllegalStateException("Email already exists");
		}
		
		// Else, save the student
		studentRepository.save(student);		
	}
}
