package com.resources;

import com.common.StudentModel;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("students")
public class StudentResource {

	@Autowired StudentService studentService;


	@PostMapping("login")
	public StudentModel login(@Valid @RequestBody StudentModel student) throws Exception {
		return studentService.login(student.getEmail(), student.getPassword());
	}

	@PostMapping("register")
	public void register(@Valid @RequestBody StudentModel studentModel) {
		studentService.register(studentModel);
	}


}
