package com.service.mapper;

import com.common.StudentModel;
import com.repository.entities.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

	StudentModel toModel(Student student);
	Student toEntity(StudentModel studentModel);

}
