package com.labs.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
//@EnableDiscoveryClient
@RestController
public class BankingappAccountserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingappAccountserviceApplication.class, args);
	}

}
