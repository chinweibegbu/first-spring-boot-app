package com.springboot.courseapp.student;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table
public class Student {
	
	@Id
	@SequenceGenerator(
			name = "studentSequence",
			sequenceName = "studentSequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "studentSequence"
	)
	private long id;
	private String name;
	private String email;
	private LocalDate dob;
	private int age;
	
	public Student() {
		super();
	}

	public Student(long id, String name, String email, LocalDate dob, int age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}

	public Student(String name, String email, LocalDate dob, int age) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return "Student {" +
				"id= " + id +
				", name= " + name +
				", email= " + email +
				", dob= " + dob +
				", age= " + age +
				"}";
	}
	
}
