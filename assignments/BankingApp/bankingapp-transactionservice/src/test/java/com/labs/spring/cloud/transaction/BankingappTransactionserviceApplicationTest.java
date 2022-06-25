package com.labs.spring.cloud.transaction;

import org.apache.catalina.core.ApplicationContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BankingappTransactionserviceApplicationTest {
	@Autowired
	ApplicationContext ctx;
	
	@Test
	public void contextLoads() {
		
	}

	@Test
	public void testApplicationContext() {
		System.out.println("Context: " + ctx);
		System.out.println("No. of Beans: " + ctx.getBeanDefinitionCount());
		Assertions.assertThat(ctx).isNotNull();
	}
}