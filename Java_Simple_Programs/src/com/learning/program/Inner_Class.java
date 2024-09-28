package com.learning.program;

class APC{
	int j;
	
	public void show() {
		System.out.println("Showing Something");
	}
	
	class ACB{
		public void show() {
			System.out.println("showing ABC");
		}
	}
	
	static class ACC{
		public void show() {
			System.out.println("showing ACC");
		}
	}
}

public class Inner_Class {
	public static void main(String[] args) {
		
		APC a= new APC();
		
		APC.ACB b= a.new ACB();
		APC.ACC C = new APC.ACC();
		a.show();
		b.show();
		C.show();
		new APC.ACC();
		
		
		
		
	}
}
