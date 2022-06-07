package com.springxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMAin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Springxml.xml");
		System.out.println(ctx);
		System.out.println("beans count"+ctx.getBeanDefinitionCount());
	}

}
