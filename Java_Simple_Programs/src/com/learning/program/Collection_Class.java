package com.learning.program;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collection_Class {
	
	public static void main(String[] args) {
		
		// List
		Collection<Integer> c = new ArrayList<>();
		
		
		
		c.add(1);
		c.add(2);
		System.out.println(c);
		for(int num: c) {
			System.out.println(num);
		}
		
		
		List<Integer> li = new ArrayList<>();
		li.add(1);
		li.add(2);
		li.add(1);
		li.remove(1);//Remove based on index
		
		
		
		System.out.println(li.get(0));
		System.out.println(li.indexOf(2));
		System.out.println(li);
		System.out.println(li.remove(1));
		
		
		//set 
		Set<Integer> se = new HashSet<>();
		se.add(1);
		se.add(81);
		se.add(1);
		se.add(3);
		se.add(0);
		
		System.out.println(se.remove(22));// remove based on value present
		
		Iterator<Integer> Itr = se.iterator();
		
		while(Itr.hasNext()) {
			System.out.println(Itr.next());
		}
		
		System.out.println(se);
		
		// Map 
		
		Map<String, Integer> student = new HashMap<>();
		
		student.put("Sushil", 1);
		student.put("Robin", 5);
		
		System.out.println(student);
		System.out.println(student.get("Sushil"));
		
		for(String sd : student.keySet()) {
			System.out.println("For the Key "+sd+ " Value is: "+ student.get(sd));
		}
		System.out.println(student.remove("Sushile", 1));
		System.out.println(student.remove("Robin"));
		
	}

}
