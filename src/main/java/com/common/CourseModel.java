package com.common;

import javax.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import lombok.Data;

@Data
@NoArgsConstructor
public class CourseModel {

	private Long id;

	@NotBlank(message = "name is mandatory")
	private String name;

	@NotBlank(message = "description is mandatory")
	private String description;

	private LocalDate publishDate;

	private LocalDate lastUpdate;

	private int totalHours;

	private String instructor;
}
