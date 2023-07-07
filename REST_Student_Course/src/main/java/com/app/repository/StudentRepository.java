package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Course;
import com.app.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	//Optional<Student> findById(Long id);
	
}
