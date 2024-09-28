package com.learning.program;
class Mobile{
	static String name;
	Mobile(){
		System.out.println("Inside Constructer");
	}
	static {
		name ="hello";
		System.out.println("Inside Static Block");
	}
	public void show() {
		System.out.println("Hello");
	}
	
}

public class Class_Forname_for_instansition {
	public static void main(String[] args) throws Exception{
		Class.forName("com.learning.program.Mobile");
	}
}
