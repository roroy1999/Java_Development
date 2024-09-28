package com.SpringAnnotationDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
				
				// get the bean from spring container 
				Coach theCoach = context.getBean("tennisCoach",Coach.class);
				
				Coach AlphaCoach = context.getBean("tennisCoach",Coach.class);
				
				// call a method on the bean
				System.out.println("pointing to the same object "+(theCoach==AlphaCoach));
				
				System.out.println("Memory Location of AlphaCoach "+(AlphaCoach));
				
				System.out.println("Memory Location of theCoach "+(theCoach));
				
				// close the context 
				context.close();

	}

}
