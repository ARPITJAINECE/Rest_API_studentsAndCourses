package com.app.service;

import java.util.List;

import com.app.entities.Course;

public interface courseService {
	// add a method to get list of all the courses
	List<Course> getListOfCourses();

	// add a method to add a new course
	Course addNewCourse(Course course);

	// add a method to delete a course one at a time
	String deleteCourse(Long courseid);

	// add a method to update the course details
	// 1: get the details of that particular course
	Course getParticularCourse(Long courseId);

	// 2: update the details of that particular employee whose id is fetched from
	// above method
	Course updateCourseDetails(Course course);

}
