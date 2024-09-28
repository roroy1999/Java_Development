package com.learning.program;

class Af{
	
	public void show1() {
		System.out.println("Inside show1");
	}
	
}

class Bf extends Af{
	public void show2() {
		System.out.println("Inside show2");
	}
}

public class DownCasting_UpCasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Af obj = new Bf();
		
		obj.show1();
		// obj.show2(); // wont work
	}

}
