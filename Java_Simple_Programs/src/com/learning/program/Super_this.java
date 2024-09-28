package com.learning.program;

class ac{
	public ac() {
		super();
		System.out.println("in A");
	}
	
	public ac(int n) {
		super();
		System.out.println("in A Int");
	}
	
     void show() {
    	 System.out.println("Inside show a");
     }
	
}

class bc extends ac{
	public bc() {
		super();
		System.out.println("in B");
	}
	
	public bc(int n) {
		//super(n);
		this();
		System.out.println("in B Int");
	}
	
	@Override
	void show() {
		super.show();
		System.out.println("Inside show B");
	}
}

public class Super_this {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//b obj = new b();
		bc obj2 = new bc(5);
		obj2.show();
		

	}

}
