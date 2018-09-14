package com.springboot.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Serializable> {
	
	Optional<Student> findByIdAndName(String id, String name);

}