package com.common;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
public class StudentModel {

	private Long id;

	private String name;

	@NotBlank(message = "email is mandatory")
	@Pattern(regexp = RegexUtils.EMAIL_PATTERN, message = "invalid Email Pattern")
	private String email;

	private String userName;

	@NotBlank(message = "password is mandatory")
	private String password;

	private String dob;

	private String gender;

}