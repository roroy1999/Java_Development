package spring_Appication1;

public class BaseballCauch implements Coach {
	
	//define a private field for the dependency
	private FortuneService fortuneServive;
	
	public BaseballCauch() {
		super();
	}

	// define a constructer for the dependency injection
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
}

