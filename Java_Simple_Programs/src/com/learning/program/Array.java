package com.learning.program;

public class Array {

	public static void main(String[] args) {
		int[] nums = new int[100];
		nums[0] = 1;
		nums[1] = 2;
		
		System.out.println(nums[0]);
		
		int[] num1 = {1,2,3,4};
		
		System.out.println(num1[1]);
		System.out.println(num1.length);
		
		String[] num2 = new String[20];
		System.out.println(num2[0]);
		float[] num3 = new float[20];
		System.out.println(num3[0]);
		char[] num4 = new char[20];
		System.out.println(num4[0]);
	}
}
