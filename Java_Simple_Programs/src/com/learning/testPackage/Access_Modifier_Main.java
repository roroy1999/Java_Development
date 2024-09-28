package com.learning.testPackage;

import com.learning.program.Access_Modifier;

public class Access_Modifier_Main {
	public static void main(String[] args) {
		Access_Modifier acc = new Access_Modifier();
		
		// System.out.println(acc.i);//Not declared public so will act as protected
		System.out.println(acc.j);
		// System.out.println(acc.k);//private 
		//System.out.println(acc.h); //Protected
		acc.i();
	}
}
