package com.learning.program;

enum Laptop{
	MacBook(2000), XPS(2200), Surface, ThinkPad(1800);//this are the constructor of Laptop
	
	private int price;

	private Laptop() {
	}

	private Laptop(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}	
}

public class ENUM_CLASS {
	public static void main(String[] args) {
		Laptop lap = Laptop.MacBook;
		System.out.println(lap);
		System.out.println(lap.getPrice());
	}
}
