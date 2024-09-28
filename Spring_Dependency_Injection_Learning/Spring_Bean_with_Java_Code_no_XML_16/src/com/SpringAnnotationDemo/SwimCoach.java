package com.SpringAnnotationDemo;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public SwimCoach() {
	}

	public SwimCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 100 meter";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
