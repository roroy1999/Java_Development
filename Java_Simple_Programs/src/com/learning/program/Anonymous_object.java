package com.learning.program;

class AB{
	AB(){
		System.out.println("inside a");
	}
	
	void show() {
		System.out.println("inside show");
	}
}

public class Anonymous_object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new AB().show(); //Anonymous Object
	}

}
