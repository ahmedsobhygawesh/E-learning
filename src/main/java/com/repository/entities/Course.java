package com.repository.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "COURSE")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PUBLISH_DATE")
	private LocalDate publishDate;

	@Column(name = "LAST_DATE")
	private LocalDate lastUpdate;

	@Column(name = "TOTAL_HOURS")
	private int totalHours;

	@Column(name = "INSTRUCTOR")
	private String instructor;

}