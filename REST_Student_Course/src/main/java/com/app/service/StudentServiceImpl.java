package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Course;
import com.app.entities.Student;
import com.app.repository.CourseReposoitory;
import com.app.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
// dependency : student repository
	@Autowired
	private StudentRepository studentRepo;

	// add course to find the min score so that the student can be admitted to that
	/*
	 * // course or not
	 * 
	 * @Autowired private CourseReposoitory courseRepo;
	 */
	@Override
	public List<Student> getListOfAllStudents() {
		System.out.println("in the method of the student service: " + getClass());
		return studentRepo.findAll();
	}

	@Override
	public Student addStudentDetails(Student stud) {
		System.out.println("in the method of the student service to add new student:  " + getClass());
		/*
		 * Optional<Course> id = courseRepo.findById(stud.getId());
		 * System.out.println("id" + id); if (id.isPresent()) {
		 * System.out.println("in outer if 1"); Course course = id.get();
		 * System.out.println("course is : " + course); if (stud.getScore() >=
		 * course.getMinScore()) {
		 * System.out.println("in the inner if of getting min score"); return
		 * studentRepo.save(stud); } }
		 */
//		return stud;
//		return studentRepo.save(stud);
		return studentRepo.save(stud);
	}

	@Override
	public String deleteStudent(Long studentId) {
		System.out.println("in the method of the student service to delete a student:  " + getClass());
		if (studentRepo.existsById(studentId)) {
			studentRepo.deleteById(studentId);
		}
		return "student deleted successfully with studentId: " + studentId;
	}

}
