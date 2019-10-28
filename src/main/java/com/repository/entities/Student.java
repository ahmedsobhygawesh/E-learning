package com.repository.entities;


import lombok.NoArgsConstructor;
import javax.persistence.*;
import lombok.Data;

@Data
@NoArgsConstructor
@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "DOB")
	private String dob;

	@Column(name = "GENDER")
	private String gender;

}