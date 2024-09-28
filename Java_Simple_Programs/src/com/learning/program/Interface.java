package com.learning.program;

interface J{
	
	int h = 12;
	String n = "hello";
	void show();
	void config();
}

interface X{
	void run();
}

interface Y extends X{
	
}
class K implements J,Y{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("In Show");
		
	}

	@Override
	public void config() {
		// TODO Auto-generated method stub
		System.out.println("In Config");
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}

public class Interface {
	public static void main(String[] args) {
		
	K obj = new K();
	obj.show();
	obj.run();
	System.out.println(obj.h);
	}
}
