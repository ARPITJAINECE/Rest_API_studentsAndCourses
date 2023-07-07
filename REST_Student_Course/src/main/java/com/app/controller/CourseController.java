package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.entities.Course;
import com.app.service.courseService;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

	// dependency: course service
	@Autowired
	private courseService courseService;

	public CourseController() {
		System.out.println("in the default constructor of the : " + getClass());
	}

	@GetMapping
	public List<Course> fetchListOfCourses() {
		System.out.println("in the method of the course controller : " + getClass());
		return courseService.getListOfCourses();
	}

	@PostMapping
	public Course launchCourse(@RequestBody Course addnewcourse) {
		System.out.println("in the method of the course controller to launch a new course: " + getClass());
		return courseService.addNewCourse(addnewcourse);
	}

	@DeleteMapping("/{courseId}")
	public ApiResponse deleteCourseById(@PathVariable Long courseId) {
		System.out.println("in the method of the course controller to delete a course: " + getClass());
		return new ApiResponse(courseService.deleteCourse(courseId));
	}

	@GetMapping("/{courseId}")
	public Course getCourseDetailsById(@PathVariable Long courseId) {
		System.out.println("in the method of the course controller to find a course: " + getClass());
		return courseService.getParticularCourse(courseId);
	}

	@PutMapping
	public Course updateCourseDetails(@RequestBody Course course) {
		System.out.println("in the method of the updating the course details : " + getClass());
		return courseService.updateCourseDetails(course);
	}

}
