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
		String newName = student.getName();
		String newEmail = student.getEmail();
		
		if(!(newName == null)) {
			if (newName .length() > 0 && studentToUpdate.getName() != newName) {
				studentToUpdate.setName(student.getName());
			} else if(newName .length() <= 0) {
				throw new IllegalStateException("Name cannot be blank");
			}
		}
		
		Optional<Student> studentWithEmail = studentRepository.getStudentByEmail(student.getEmail());
		
		if(studentWithEmail.isPresent()) {
			throw new IllegalStateException("New email already exists");
		} else if(!(newEmail == null)) {
			if(newEmail.length() > 0 && studentToUpdate.getEmail() != newEmail) {
				studentToUpdate.setEmail(student.getEmail());
			} else if(newEmail.length() <= 0) {
				throw new IllegalStateException("Email cannot be blank");
			}
		}
		
		studentRepository.save(studentToUpdate);
	}
}
