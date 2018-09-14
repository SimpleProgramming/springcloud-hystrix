package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.model.Student;
import com.springboot.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private StudentRepository studentRepository;

	@HystrixCommand(fallbackMethod = "fallBackMethodForStudentService")
	public Student saveStudentInformation(Student student) {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.add("test_header", "test_header");
		HttpEntity<String> httpEntity = new HttpEntity<>(student.toString(), httpHeaders);

		ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:1234/approval", HttpMethod.POST,
				httpEntity, String.class);

		// get approval code, set it in the student object and save to database

		return studentRepository.save(student);
	}

	public Student fallBackMethodForStudentService(Student student) {
		student.setResponse("our systems are under maintanence, but we are unable to process the request now!");
		return student;
	}
}
