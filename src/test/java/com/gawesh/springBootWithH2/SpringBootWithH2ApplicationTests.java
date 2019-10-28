package com.gawesh.springBootWithH2;

import com.repository.StudentRepository;
import com.repository.entities.Student;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;
import com.service.mapper.StudentMapper;
import com.service.mapper.StudentMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class SpringBootWithH2ApplicationTests {


	@Autowired StudentService studentService;
	@Autowired StudentMapper studentMapper;
	@MockBean StudentRepository studentRepository;
	Student student;

	@BeforeEach
	public void setup() {
		when(studentRepository.save(any(Student.class))).then( invocation -> {
			Student stu = invocation.getArgument(0);
			stu.setId(1L);
			return stu;
		});
	}


	@Test
	public void addStudent_shouldAddIt() {
		student = new Student(1L, "Ahmed" , "ahmed@e-learning.com");
			studentService.register(studentMapper.toModel(student));
			verify(studentRepository).save(student);
			assertThat(student.getId()).isEqualTo(1);
	}



	@TestConfiguration
	static class configurationContext {

		@Bean
		public StudentService studentService() {
			return new StudentServiceImpl();
		}

		@Bean
		public StudentMapper studentMapper() {
			return new StudentMapperImpl();
		}
	}

}
