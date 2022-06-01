package com.sparta.spring_homework2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringHomework2Application {
	public static void main(String[] args) {
		SpringApplication.run(com.sparta.spring_homework2.SpringHomework2Application.class, args);
	}
}
