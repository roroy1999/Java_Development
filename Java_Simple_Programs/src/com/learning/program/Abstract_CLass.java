package com.learning.program;

abstract class Car {
	public abstract void drive();
	public abstract void fly();
	
	public void music() {
		System.out.println("Play music");
	}
}

abstract class WagonR extends Car{
	@Override
	public void drive() {
		// TODO Auto-generated method stub
		
		System.out.println("Driving");
		
	}
}

class UpdatedWagonR extends WagonR{
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
		System.out.println("fly");
		
	}
}

public class Abstract_CLass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car cr = new UpdatedWagonR();
		
		cr.drive();
		cr.music();
		cr.fly();
	}

}
