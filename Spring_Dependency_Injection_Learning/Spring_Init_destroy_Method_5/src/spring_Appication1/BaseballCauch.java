package spring_Appication1;

public class BaseballCauch implements Coach {
	
	//define a private field for the dependency
	private FortuneService fortuneServive;
	
	public BaseballCauch() {
		super();
	}

	// define a Constructer for the dependency injection
	public BaseballCauch(FortuneService theFotuneService) {
		this.fortuneServive = theFotuneService;
	}
	
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		
		// use my fortuneService to get a fortune
		
		return fortuneServive.getFortune();
	}
	
	//add an init method
	
	public void doMyStartupStuff() {
		System.out.println("BaseballCauch: inside method doMyStartupStuff");
	}
	
	// add a destroy method
	public void doMyCleanupStuffYoYo() {
		System.out.println("BaseballCauch: inside method doMyCleanupStuffYoYo");
	}
}

