package com.springboot.courseapp.student;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/students")
public class StudentController {
	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
}
