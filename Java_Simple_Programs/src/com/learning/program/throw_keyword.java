package com.learning.program;

class RobinException extends Exception{
	
	public RobinException(String s) {
		super(s);
	}
	
}

public class throw_keyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int j = 20;
		int i =10;
		try {
			if(i == 9) {
				throw new ArithmeticException("it failed");
			}
			else if(i==10) {
				throw new RobinException("Messed Up");
			}
			i = 18/j;
		}catch(ArithmeticException e) {
			i = 18/1;
			System.out.println("Thats the default output : "+ e);
		}catch(Exception e) {	
			System.out.println("Inside overall exception : " + e);
		}
		System.out.println(i);
		System.out.println("Bye");
	}

}
