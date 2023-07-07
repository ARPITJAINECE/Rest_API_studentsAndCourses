package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.entities.Student;
import com.app.service.StudentService;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
//depe: student Service
	@Autowired
	private StudentService studentService;

	public StudentController() {
		System.out.println("in the default constructor of the : " + getClass());
	}

	@GetMapping
	public List<Student> fetchListOfAllStudents() {
		System.out.println("in the method of the student controller : " + getClass());
		return studentService.getListOfAllStudents();
	}

	@PostMapping
	public Student addNewStudentDetails(@RequestBody Student student) {
		System.out.println("in the method of the student controller to add a new student details : " + getClass());
		return studentService.addStudentDetails(student);
	}

	@DeleteMapping("/{studentId}")
	public ApiResponse deleteStudentById(@PathVariable Long studentId) {
		System.out.println("in the method of the student controller to delete a student  : " + getClass());
		return new ApiResponse(studentService.deleteStudent(studentId));
	}

}
