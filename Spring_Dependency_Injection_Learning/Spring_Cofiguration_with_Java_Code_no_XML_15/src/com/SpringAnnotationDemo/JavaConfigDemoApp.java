package com.SpringAnnotationDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		        // read spring config java class
		        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
				
				// get the bean from spring container 
				Coach theCoach = context.getBean("tennisCoach",Coach.class);
				
				// call a method on the bean
				System.out.println(theCoach.getDailyWorkout());
				
				// close the context 
				context.close();

	}

}
