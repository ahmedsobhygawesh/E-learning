package com.repository.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "STUDENT_COURSE")
public class StudentCourses {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Student student;

	@ManyToOne
	private Course course;

	public StudentCourses(Student student, Course course) {
		this.student = student;
		this.course = course;
	}

}
