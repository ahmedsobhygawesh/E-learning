package com.service;

import com.common.CourseModel;
import com.repository.entities.Course;

import java.util.List;

public interface CourseService {

	List<CourseModel> findAllCourses();

	List<CourseModel> findStudentCourses(Long studentId);

	void registerToCourse(Long studentId, Long courseId) throws Exception;

	void unRegisterToCourse(Long studentIdentifier, Long courseIdentifier);

	void saveCourse(CourseModel courseModel);


}
