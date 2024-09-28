package com.learning.program;

public class Advanced_Calculator extends Calculator1 {
	
	public int multi(int n1,int n2) {
		return n1*n2;
	}
	
	public int div(int n1,int n2) {
		return n1/n2;
	}

}

class VeryAdavacedCalculator extends Advanced_Calculator{
	
	double power(int n1,int n2) {
		return Math.pow(n1, n2);
	}
}
