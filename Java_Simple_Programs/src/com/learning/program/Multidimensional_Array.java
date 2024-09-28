package com.learning.program;
import java.util.Scanner;

public class Multidimensional_Array {
	
	public static void main(String[] args) {
		int nums[][] = new int[3][];
		nums[0] = new int[3];
		nums[1] = new int[2];
		nums[2] = new int[4];
		Scanner sc =  new Scanner(System.in);
		
		for(int i=0;i<nums.length;i++) {
			
		   for(int j=0;j<nums[i].length;j++) {
			   //System.out.println("Please enter " + i + "    "+ j + "Value");
			   
			   nums[i][j] = (int)(Math.random()*10);
		   }
			
		}
		
		for(int num[]:nums) {
			
			   for(int m : num) {
				   System.out.print(m+" ");

			   }
			   System.out.print("\n");
				
			}
	}

}
