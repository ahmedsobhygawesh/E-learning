package com.repository;

import com.repository.entities.Course;
import com.repository.entities.StudentCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourses, Long> {

	@Query("SELECT sc.course FROM StudentCourses sc WHERE sc.student.id = ?1")
	List<Course> findCoursesByStudentId(Long studentId);


	@Modifying
	@Query("DELETE FROM StudentCourses sc WHERE sc.student.id = ?1 AND sc.course.id = ?2")
	void deleteCoursesByStudentId(Long studentId, Long courseId);

}
