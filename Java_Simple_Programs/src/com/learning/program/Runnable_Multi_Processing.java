package com.learning.program;

class Tr3 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<=5;i++) {
			System.out.println("Hello");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Tr4 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<=5;i++) {
			System.out.println("Hi");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class Runnable_Multi_Processing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tr3 obj1 = new Tr3();
		Tr4 obj2 = new Tr4();
		
		Thread tr1 = new Thread(obj1);
		Thread tr2 = new Thread(obj2);
		
		//System.out.println(obj1.getPriority());
		
		//obj2.setPriority(Thread.MAX_PRIORITY);
		
		tr1.start();
		tr2.start();

	}

}
