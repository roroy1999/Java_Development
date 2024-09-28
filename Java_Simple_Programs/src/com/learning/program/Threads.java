package com.learning.program;

class Tr1 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<=1000;i++) {
			System.out.println("Hello");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.run();
	}
}

class Tr2 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<=1000;i++) {
			System.out.println("Hi");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.run();
	}
}

public class Threads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tr1 obj1 = new Tr1();
		Tr2 obj2 = new Tr2();
		
		//System.out.println(obj1.getPriority());
		
		//obj2.setPriority(Thread.MAX_PRIORITY);
		
		obj1.start();
		obj2.start();
	}

}
