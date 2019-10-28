package com.resources;

import com.service.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.service.CourseService;
import com.common.CourseModel;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseResourse {

	@Autowired CourseService courseService;
	@Autowired CourseMapper courseMapper;

	@GetMapping
	public List<CourseModel> findAllCourses() {
		return courseService.findAllCourses();
	}

	@PostMapping
	public void saveCourse(@Valid @RequestBody CourseModel courseModel) {
		courseService.saveCourse(courseModel);
	}

	@GetMapping("students/{studentId}")
	public List<CourseModel> findStudentCourses(@PathVariable Long studentId) {
		return courseService.findStudentCourses(studentId);
	}

	@PostMapping("{courseId}/students/{studentId}/register")
	public void registerToCourse(@PathVariable Long studentId, @PathVariable Long courseId) throws Exception {
		courseService.registerToCourse(studentId, courseId);
	}

	@Transactional
	@DeleteMapping("{courseId}/students/{studentId}/un-register")
	public void unRegisterToCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
		courseService.unRegisterToCourse(studentId, courseId);
	}



}