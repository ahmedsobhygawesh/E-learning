package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@ComponentScan(basePackages = "com.**")
public class SpringBootWithH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithH2Application.class, args);
		System.out.println("Start point");
	}

}
