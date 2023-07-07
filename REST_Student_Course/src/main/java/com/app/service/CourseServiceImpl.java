package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Course;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.CourseReposoitory;

@Service
@Transactional
public class CourseServiceImpl implements courseService {
// dependency: course Repository
	@Autowired
	private CourseReposoitory courseRepo;

	@Override
	public List<Course> getListOfCourses() {
		System.out.println("in the method of the service layer: " + getClass());
		return courseRepo.findAll();
	}

	@Override
	public Course addNewCourse(Course course) {
		System.out.println("in the method of the service layer to add new course: " + getClass());
		return courseRepo.save(course);
	}

	@Override
	public String deleteCourse(Long courseid) {
		System.out.println("in the method of the service layer to delete a course: " + getClass());
		if (courseRepo.existsById(courseid)) {
			courseRepo.deleteById(courseid);
		}
		return "course deleted successfully with course id : " + courseid;
	}

	@Override
	public Course getParticularCourse(Long courseId) {
		System.out.println("in the method of the service layer to find a course by its id: " + getClass());
		return courseRepo.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException(courseId + " : is not found"));
	}

	@Override
	public Course updateCourseDetails(Course course) {
		System.out.println("in the method of the service layer to update the course details: " + getClass());
		return courseRepo.save(course);
	}

}
