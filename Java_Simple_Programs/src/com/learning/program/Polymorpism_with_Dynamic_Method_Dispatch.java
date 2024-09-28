package com.learning.program;

class AClass{
	public void show() {
		System.out.println("Hello");
	}
}

class BClass extends AClass{
	public void show() {
		System.out.println("Hello class B");
	}
}

class CClass extends AClass{
	public void show() {
		System.out.println("Hello class B");
	}
}

public class Polymorpism_with_Dynamic_Method_Dispatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AClass a = new BClass();
		//BClass b = new AClass();
		a.show();
		
		a = new CClass();// different behavior in different object so called polymorphism
		a.show();
		
		a = new AClass();
		a.show();
		
		
	}

}
