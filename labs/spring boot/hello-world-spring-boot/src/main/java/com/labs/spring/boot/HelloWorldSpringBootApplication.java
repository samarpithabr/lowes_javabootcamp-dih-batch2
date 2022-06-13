package com.labs.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloWorldSpringBootApplication implements CommandLineRunner {
@Autowired
ApplicationContext context;
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(context.getBeanDefinitionCount());
		Greetings greetings=context.getBean(Greetings.class);
		greetings.setMessage("my name is sam");
		System.out.println(greetings.getMessage());
		GreetingsService greetingservice=context.getBean(GreetingsService.class);
		greetingservice.getit();
	}
@Bean
public Greetings greetings() {
	return new Greetings();
	
}
@Bean
public GreetingsService greetingsService() {
	return new GreetingsService();
}
}
