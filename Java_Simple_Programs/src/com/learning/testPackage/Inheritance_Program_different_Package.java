package com.learning.testPackage;
import com.learning.program.*;

public class Inheritance_Program_different_Package {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator1 cal = new Calculator1();
		System.out.println(cal.add(1, 5));
		System.out.println(cal.sub(6, 7));
		Advanced_Calculator acal = new Advanced_Calculator();//Single level inheritence
		System.out.println(acal.add(1, 5));
		System.out.println(acal.sub(6, 7));
		System.out.println(acal.multi(1, 5));
		System.out.println(acal.div(6, 7));
		
		
	}

}
