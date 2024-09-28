package com.learning.program;

class Outer{
	public void show() {
		System.out.println("In A Show");
	}
}

abstract class Outer1{
	public void show() {
		System.out.println("In A Show");
	}
}

public class Anonymous_Inner_Class {
	public static void main(String[] args) {
		Outer out = new Outer() {
			public void show() {
				System.out.println("In New Show");
			}
		};
		
		out.show();
		
		Outer1 out1 = new Outer1() {
			public void show() {
				System.out.println("In New Show");
			}
		};
		
		out1.show();
	}
}
