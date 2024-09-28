package com.learning.program;

public class String_Buffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuffer sb = new StringBuffer();
		StringBuffer sb1 = new StringBuffer("Hello");
		System.out.println(sb.capacity());
		System.out.println(sb1.capacity());
		sb.append("robin");
		sb1.append("robin");
		String str1 = sb1.substring(0,3).toString();
		System.out.println(str1);
		System.out.println(sb.capacity());
		System.out.println(sb1.capacity());
		System.out.println(sb);
		System.out.println(sb1);
		String str = sb.toString();//type case to string
		System.out.println(str);
		sb.setLength(3);
		System.out.println(sb);
		StringBuilder sbu  = new StringBuilder();
		sbu.append("Heelo");
		
		System.out.println(sbu);
		String str12 = sbu.toString();
		System.out.println(str12);
		
	}

}
