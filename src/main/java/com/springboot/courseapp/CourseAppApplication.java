package com.springboot.courseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class CourseAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseAppApplication.class, args);
	}
	
	@GetMapping
	public String Demo() {
		return "Hello, World";
	}
}
