package com.learning.program;
class bobile{
	static String name;
	bobile(){
		System.out.println("Inside Constructer");
	}
	static {
		name ="hello";
		System.out.println("Inside Static Block");
	}
}

public class Static_class {
	public static void main(String[] args) {
		bobile m = new bobile();
		System.out.println(m.name);
		m.name = "samsung";
		bobile b = new bobile();
		
		System.out.println(b.name);
	}
}
