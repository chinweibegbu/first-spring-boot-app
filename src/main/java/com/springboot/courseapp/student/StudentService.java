package com.springboot.courseapp.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

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
}
