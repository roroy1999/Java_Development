package spring_Appication1;

public class MyApp {

	public static void main(String[] args) {
		
		//create the object
		Coach theCouch1 = new BaseballCauch();
		
		Coach theCouch2 = new trackCoach();
		
		System.out.println(theCouch1.getDailyWorkout());
		System.out.println(theCouch2.getDailyWorkout());
		

	}

}
