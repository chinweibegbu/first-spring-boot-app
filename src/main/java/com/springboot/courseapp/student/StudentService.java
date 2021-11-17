package com.springboot.courseapp.student;
import java.util.*;
import javax.transaction.Transactional;
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

	public void deleteStudent(Long studentId) {
		// Get student with the given ID
		boolean exists = studentRepository.existsById(studentId);
		
		if(!exists) {
			throw new IllegalStateException("Student with an id of " + studentId + " does not exist");
		}
		
		// Else, save the student
		studentRepository.deleteById(studentId);
	}

	@Transactional
	public void updateStudent(Student student, Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		
		if(!exists) {
			throw new IllegalStateException("Student with an id of " + studentId + " does not exist");
		}
		
		Student studentToUpdate = studentRepository.getById(studentId);
		studentToUpdate.setName(student.getName());
		studentToUpdate.setEmail(student.getEmail());
		
		studentRepository.save(studentToUpdate);
	}
}
