package com.SpringAnnotationDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationLifeCycleDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
				
				// get the bean from spring container 
				Coach theCoach = context.getBean("tennisCoach",Coach.class);
				
				// call a method on the bean
				System.out.println(theCoach.getDailyWorkout());
				
				// close the context 
				context.close();

	}

}
