package com.service.impl;

import com.common.CourseModel;
import com.repository.CourseRepository;
import com.repository.StudentCourseRepository;
import com.repository.StudentRepository;
import com.repository.entities.Course;
import com.repository.entities.Student;
import com.repository.entities.StudentCourses;
import com.service.CourseService;
import com.service.mapper.CourseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

	@Autowired CourseMapper courseMapper;
	@Autowired CourseRepository courseRepository;
	@Autowired StudentRepository studentRepository;
	@Autowired StudentCourseRepository studentCourseRepository;

	@Override
	public List<CourseModel> findAllCourses() {
		return courseRepository.findAll().stream().map(c ->
			courseMapper.toModel(c)).collect(Collectors.toList());
	}

	@Override
	public List<CourseModel> findStudentCourses(Long studentIdentifier) {
		return studentCourseRepository.findCoursesByStudentId(studentIdentifier)
				.stream()
				.map(c -> courseMapper.toModel(c)).collect(Collectors.toList());

	}

	@Override
	public void registerToCourse(Long studentIdentifier, Long courseIdentifier) throws Exception {

		Optional<Student> student = Optional.ofNullable(studentRepository.findById(studentIdentifier).orElseThrow(() -> new Exception("")));
		Optional<Course> course = Optional.ofNullable(courseRepository.findById(courseIdentifier).orElseThrow(() -> new Exception("")));
		StudentCourses studentCourses = new StudentCourses(student.get(), course.get());
		try {
			studentCourseRepository.save(studentCourses);
		} catch (Exception ex) {
			log.info(ex.getMessage());
		}
		log.info("student registered to " + studentCourses.getCourse().getName() + " course");

	}

	@Transactional
	@Modifying
	@Override
	public void unRegisterToCourse(Long studentIdentifier, Long courseIdentifier) {
		studentCourseRepository.deleteCoursesByStudentId(studentIdentifier, courseIdentifier);
	}

	@Override
	public void saveCourse(CourseModel courseModel) {
		courseRepository.save(courseMapper.toEntity(courseModel));
	}
}
