package com.learning.program;

class counter{
	int count;
	public synchronized void increment() {
		this.count=this.count+1;
	}
}

public class Syncronizes_Thread_safety {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		counter c = new counter();
		Runnable obj1 = () ->{
			for(int i=1;i<=1000;i++) {
				c.increment();
			}
		};
		
		Runnable obj2 = () ->{
			for(int i=1;i<=1000;i++) {
				c.increment();				
			}
		};
		
		Thread tr1 = new Thread(obj1);
		Thread tr2 = new Thread(obj2);
		
		tr1.start();
		tr2.start();
		
		tr1.join();
		tr2.join();
		
		System.out.println(c.count);

	}

}
