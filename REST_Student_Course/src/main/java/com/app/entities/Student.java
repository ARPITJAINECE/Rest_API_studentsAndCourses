package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends BaseEntity {
	@Column(name = "first_name")
	private String firstName;
	private String email;
	private int score;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String firstName, String email, int score, Course course) {
		super();
		this.firstName = firstName;
		this.email = email;
		this.score = score;
		this.course = course;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", email=" + email + ", score=" + score + ", course=" + course + "]";
	}

}
