package com.learning.program;

public class Exception_Handling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int j = 0;
		int i =9;
		int[] s = new int[5];
		try {
			int k = s[5];
			i = 18/j;
		}catch(ArithmeticException e) {
			System.out.println("Something went wrong. " + e);
		}catch(Exception e) {	
			System.out.println("Inside overall exception : " + e);
		}
		System.out.println(i);
		System.out.println("Bye");

	}

}
