package com.learning.program;

public class Object_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student s1 = new Student();
		s1.rollno = 1;
		s1.marks=99;
		s1.name="penga";
		Student s2 = new Student();
		s2.rollno = 2;
		s2.marks=100;
		s2.name="pepe";
		
		Student[] sArray = new Student[2];
		sArray[0]= s1;
		sArray[1]= s2;
		
		for(Student i : sArray) {
			System.out.println(i.name);
		}
	}

}

class Student{
	int rollno;//instances
	int marks;
	String name ;
}
