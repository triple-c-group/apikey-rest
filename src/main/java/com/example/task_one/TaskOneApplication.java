package com.example.task_one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class TaskOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskOneApplication.class, args);
	}

}
