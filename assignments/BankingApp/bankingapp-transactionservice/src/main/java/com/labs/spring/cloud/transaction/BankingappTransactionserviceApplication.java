package com.labs.spring.cloud.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BankingappTransactionserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingappTransactionserviceApplication.class, args);
	}

}
