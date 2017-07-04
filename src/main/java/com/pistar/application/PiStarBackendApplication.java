package com.pistar.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@ComponentScan("com.pistar")
public class PiStarBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiStarBackendApplication.class, args);
	}
}
