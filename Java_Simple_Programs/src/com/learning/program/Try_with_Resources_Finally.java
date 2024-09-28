package com.learning.program;

public class Try_with_Resources_Finally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 2;
		int j = 0;
		try {
			j = 18/i;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Something went wrong");
		} finally {
			System.out.println("Bye");
		}
	}

}
