package com.service.impl;

import com.common.StudentModel;
import com.repository.StudentRepository;
import com.service.StudentService;
import com.service.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired StudentMapper studentMapper;
	@Autowired StudentRepository studentRepository;

	@Override
	public StudentModel login(String studentEmail, String studentPassword) throws Exception {
		StudentModel studentModel = studentMapper.toModel(studentRepository.findStudentByEmailAndPassword(studentEmail, studentPassword));
		if (studentModel == null) {
			throw new Exception("Bad Credential");
		}
		log.info("login successful");
		return studentModel;
	}

	@Override
	public void register(StudentModel studentModel) {
		try {
			studentRepository.save(studentMapper.toEntity(studentModel));
		} catch (Exception ex) {
		log.info(ex.getMessage());
		}
		log.info("customer " + studentModel.getEmail() + " saved");
	}
}
