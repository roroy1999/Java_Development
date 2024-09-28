package com.learning.program;

public class Hello_world {

	public static void main(String args[]) {
		System.out.println("hello world");
		Robin robin = new Robin();
		System.out.println(robin.s);
		float num = 7.3f;
		System.out.println(num);
		boolean b = true;
		System.out.println(b);
		byte  by= 127;
		System.out.println(by);
		by = (byte) 257;
		System.out.println(by);
		by+=2;
		System.out.println(by);
		if(by==3) 
			System.out.println("1st condition");
		 else if(by==4) {
			System.out.println("2nd condition");
		}else {
			System.out.println("3rd condition");
		}
		switch (by) {
		case 3: {
			
			System.out.println("switch1");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + 2);
		}
		
		boolean test = by==4?true:false;
		
		System.out.println("result is :" + test);
		
		for(int i=0 ; i<=10;++i) {
			System.out.println("o yea "+ i);
		}
		int j = 0;
		while(j<100) {
			++j;
			System.out.println("bsdk"+ j);
		}
		System.out.println("Final bsdk"+ j);
	}
}

class Robin{
	String s = "hello worl";
}
