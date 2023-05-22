package com.demo.testorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class TestOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestOrderServiceApplication.class, args);
	}

}
