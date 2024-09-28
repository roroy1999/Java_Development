package com.learning.program;

enum Status{
	Running, Failed, Pending, Success;
}

public class Enum {
	
	public static void main(String[] args) {
		
		Status s = Status.Running;
		
		System.out.println(s);
		System.out.println(s.ordinal());
		s = Status.Pending;
		System.out.println(s.ordinal());
		Status[] s1 = Status.values();
		System.out.println(s1[1]);
		
		if(s==Status.Pending) {
			System.out.println("Pending");
		}
		
		switch(s) {
		case Pending:
			System.out.println("Pending");
			break;
		default:{
			System.out.println("Done");
			break;
		}
		}
		
	

}}
