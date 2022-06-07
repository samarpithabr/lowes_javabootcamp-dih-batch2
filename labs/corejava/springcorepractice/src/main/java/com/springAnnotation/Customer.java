package com.springAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;





public class Customer {
	

	private Person person;
	
	public Customer()
	{
		
	}
	

	public Customer(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	

}
