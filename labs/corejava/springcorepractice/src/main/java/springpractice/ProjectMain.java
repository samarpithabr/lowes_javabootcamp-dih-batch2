package springpractice;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class ProjectMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");
		
		System.out.println("No of beans: " + context.getBeanDefinitionCount());
		for (String beanName : context.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
		
		Car bmw = (Car) context.getBean("bmw");
		
	System.out.println("Manufacturer: " + bmw.getManufacturer());
	System.out.println("Color: " + bmw.getColor());
	System.out.println("Capacity: " + bmw.getEngine().getCapacity());
		
		context.registerShutdownHook();
		
		
	}
}