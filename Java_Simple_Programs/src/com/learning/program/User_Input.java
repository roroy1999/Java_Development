package com.learning.program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class User_Input {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Please enter a value");
		
		//int num = System.in.read();
		
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		
//		String s = bf.readLine();
//		
//		int ss = Integer.parseInt(s);
//		
//		
//		//System.out.println(num);
//		System.out.println(ss);
		
		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt();
		String str = sc.next();
		
		System.out.println(i +" : "+ str);
	}

}
