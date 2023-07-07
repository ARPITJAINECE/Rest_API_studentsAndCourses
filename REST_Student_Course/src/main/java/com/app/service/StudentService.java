package com.app.service;

import java.util.List;

import com.app.entities.Student;

public interface StudentService {
// add a method to get a list of all the students
	List<Student> getListOfAllStudents();

	// add a method to insert the student details in the DB
	Student addStudentDetails(Student stud);

	// add a method to delete a student at once by
	String deleteStudent(Long studentId);
}
