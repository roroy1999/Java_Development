package spring_Appication1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		//Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieving bean from spring container 
		Coach theCouach = context.getBean("myCoach",Coach.class);
		
		// call method on the bean
		System.out.println(theCouach.getDailyWorkout());
		
		//lets call our new method for fortunes
		System.out.println(theCouach.getDailyFortune());
		
		// close the context 
		context.close();
		

	}

}
