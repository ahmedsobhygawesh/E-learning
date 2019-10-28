package com.service.mapper;

import com.common.CourseModel;
import com.repository.entities.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

	CourseModel toModel(Course course);
	Course toEntity(CourseModel courseModel);

}
