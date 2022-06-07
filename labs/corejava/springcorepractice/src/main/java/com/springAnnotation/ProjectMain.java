package com.springAnnotation;

import javax.naming.Context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;







public class ProjectMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);

		Customer obj = (Customer) context.getBean(Customer.class);
		System.out.println("Customer: " + obj);
		System.out.println("Dependent Person: " + obj.getPerson());

		Person obj1 = (Person) context.getBean(Person.class);
		System.out.println("CommonMan: " + obj1);
		
//		obj.getPerson().setName("Anand");
//		obj.getPerson().setAge(40);
//		obj.getPerson().setLocation("Cochin");
		
		System.out.println(
				obj.getPerson().getName() + " " + obj.getPerson().getAge() + " " + obj.getPerson().getLocation());		

		context.registerShutdownHook();
	}
}
