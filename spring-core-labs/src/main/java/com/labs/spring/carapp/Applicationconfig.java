package com.labs.spring.carapp;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class Applicationconfig {
	@Bean(autowire = Autowire.BY_TYPE,initMethod = "init",destroyMethod = "destry")
	@Lazy(value = true)
	@Scope("singleton")
	public Car bmw() {
		return new Car("xma","tata","grey",petrol());
		
	}
	@Bean
	public Car nexon() {
		Car nexon=new Car("xza","Tata","asdsd");
		nexon.setEngine(petrol());;
		return nexon;
	}
	@Bean
	public Engine petrol() {
		return new Engine("petrol",3400);
	}
@Bean

public Engine deisel() {
	return new Engine("diesel", 230);
}
public void init() {
	System.out.println("init method");
}
public void destroy() {
	System.out.println("destroy method");
}
}
