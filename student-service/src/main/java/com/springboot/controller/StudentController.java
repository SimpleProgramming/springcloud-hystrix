package com.springboot.controller;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Student;
import com.springboot.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Value("${config.server.student-key}")
	private String propertyKey;
	
	@GetMapping
	public String fetchProperty() {
		return propertyKey;
	}
	
	@PostMapping
	public void saveStudentInformation1(@RequestBody Student student) {
			studentService.saveStudentInformation(student);
	}

}
