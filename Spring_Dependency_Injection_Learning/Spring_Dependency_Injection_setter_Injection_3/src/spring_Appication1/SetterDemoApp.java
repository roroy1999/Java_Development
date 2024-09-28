package spring_Appication1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		//Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieving bean from spring container 
		CricketCoach theCouach = context.getBean("myCricketCoach",CricketCoach.class);
		
		// call method on the bean
		System.out.println(theCouach.getDailyWorkout());
		
		System.out.println(theCouach.getDailyFortune());
		
		// call our new methods to get the litteral values 
		System.out.println(theCouach.getEmailAddress());
		
		System.out.println(theCouach.getTeam());
		
		
		// close the context 
		context.close();
		

	}

}
