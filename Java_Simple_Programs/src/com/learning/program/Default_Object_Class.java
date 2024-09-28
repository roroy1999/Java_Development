package com.learning.program;

class Model { // extends Object by default
	int j=1;
	int k=2;
	
	// overide equals method
	
	public boolean equals(Model that) {
		if(this.j == that.j && this.k == that.k) {
			return true;
		}
		
		return false;
	}
}

class Model1 { // extends Object by default
	int j=1;
	int k=2;
	
	@Override
	public String toString() {
		return "hey";
	}
}

public class Default_Object_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Model ms = new Model();
		Model ms3 = new Model();
		System.out.println(ms);
		
        Model1 ms1 = new Model1();
        Model1 ms2 = new Model1();
		System.out.println(ms1);
		System.out.println(new Model1());
		
		System.out.println(ms1.equals(ms2));
		System.out.println(ms.equals(ms3));
	}

}
