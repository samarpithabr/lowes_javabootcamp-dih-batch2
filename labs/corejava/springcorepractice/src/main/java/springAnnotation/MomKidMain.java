package springAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MomKidMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context=new AnnotationConfigApplicationContext("BeansAnnotation.xml");
Mom mom=(Mom) context.getBean("mom");
System.out.println(mom);
	}

}
