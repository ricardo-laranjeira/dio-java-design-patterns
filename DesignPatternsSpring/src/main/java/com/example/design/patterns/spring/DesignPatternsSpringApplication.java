package com.example.design.patterns.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesignPatternsSpringApplication {
	//http://localhost:8080/swagger-ui/index.html
	public static void main(String[] args) {
		SpringApplication.run(DesignPatternsSpringApplication.class, args);
	}

}
