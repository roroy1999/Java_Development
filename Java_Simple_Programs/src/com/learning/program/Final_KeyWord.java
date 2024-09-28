package com.learning.program;

final class Calc{
	public void show() {
		System.out.println("Inside Calc");
	}
}

/*

class AdvCalc extends Calc {// wont work
	
}
*/

class FinalMethod{
	public final void show() {
		System.out.println("Inside FinalMethod");
	}
}

class FinalMethodChild extends FinalMethod{
//	public void show() {
//		System.out.println("Inside FinalMethod"); // wont work since method overiding is blocked by final
//	}
}

public class Final_KeyWord {

	public static void main(String[] args) {
		final int num = 4;
		//num = 9; //you wont be able to change it
		System.out.println(num);
		Calc c = new Calc();
		c.show();
	}
}
