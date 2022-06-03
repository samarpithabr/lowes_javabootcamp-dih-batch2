  
package com.labs.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Greetings greet=new Greetings();
//System.out.println(greet.getMessag());
ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-config.xml");
System.out.println(ctx);
System.out.println("beans count"+ctx.getBeanDefinitionCount());
Greetings greetings=ctx.getBean("greetings",Greetings.class);
System.out.println(greetings.getMessage());

	}

}
