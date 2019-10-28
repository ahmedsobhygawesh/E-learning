package com.service;

import com.common.StudentModel;

public interface StudentService {

	StudentModel login(String studentEmail, String studentPassword) throws Exception;

	void register(StudentModel studentModel);
}
