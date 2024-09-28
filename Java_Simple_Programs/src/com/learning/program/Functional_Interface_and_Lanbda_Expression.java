package com.learning.program;

@FunctionalInterface
interface D{
	public void show();
	//public void show1(); --> wont work since Functional interface can have only one method
}

@FunctionalInterface
interface F{
	public int show(int i);
	
}

@FunctionalInterface
interface Z{
	public int show(int i,int l);
	
}

public class Functional_Interface_and_Lanbda_Expression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		D d = new D() {

			@Override
			public void show() {
				// TODO Auto-generated method stub
				System.out.println("Hello");
			}
			
		};
		
		D dd = ()->{
			System.out.println("Hello");
		};
		
		D ddd = ()->System.out.println("Hello");
		
		F ff = i->{
			return i;
			};
			
		Z z = (i,n) ->i+n;
		d.show();
		dd.show();
		ddd.show();
		
		System.out.println(ff.show(1));
		System.out.println(z.show(2, 5));

	}

}
