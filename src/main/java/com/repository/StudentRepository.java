package com.repository;

import com.repository.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query("SELECT s FROM Student s WHERE s.email = ?1 AND s.password = ?2")
	Student findStudentByEmailAndPassword(String email, String password);

}
