package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class HelloSpringBootDemoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootDemoWebApplication.class, args);
		
	}
	
}
