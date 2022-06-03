package com.labs.spring.carapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
AbstractApplicationContext context=new AnnotationConfigApplicationContext(Applicationconfig.class);
System.out.println(context.getBeanDefinitionCount());
for (String beanname : context.getBeanDefinitionNames()) {
	System.out.println(beanname);
}
Car bmw=context.getBean("bmw",Car.class);
System.out.println(bmw.getColor()+bmw.getManufacturer()+bmw.getModel()+bmw.getEngine());
context.registerShutdownHook();
	}

}
