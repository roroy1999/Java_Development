package com.robin.SpringDemo;

public class Alien {
	
	private int age;
	
	private Computer com;
	
	public int getAge() {
		return age;
	}

	public Computer getCom() {
		return com;
	}

	public void setCom(Computer com) {
		this.com = com;
	}

	public void setAge(int age) {
		System.out.println("Age Assigned");
		this.age = age;
	}
	public Alien() {
		System.out.println("Alien CONSTRUCTER");
	}
	public void code() {
		System.out.println("Im Coding..");
		com.compile();
	}
//	public Alien(int age) {
//		super();
//		this.age = age;
//	}
}
