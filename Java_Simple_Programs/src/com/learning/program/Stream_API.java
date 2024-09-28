package com.learning.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_API {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> li = Arrays.asList(1,2,3,4);
		
		//System.out.println(li);
		//li.forEach(n->System.out.println(n));
		
		Stream<Integer> s1 = li.stream();
		Stream<Integer> s2 = s1.filter(n -> n%2==0);
		Stream<Integer> s3 = s2.map(n->n*2);
		
		int result1 = s3.reduce(0, (c,e)-> c+e);
		
		int result2 = li.stream().filter(n->n%2==0).map(n->n*2).reduce(2, (c,e)->c+e);
		
		List<Integer> lv = li.stream().filter(n->n%2==0).map(n->n*2).collect(Collectors.toList());
		
		//s1.forEach(n->System.out.println(n));
		//s.forEach(n->System.out.println(n)); //cannot reuse this expression
		
		//s3.forEach(n->System.out.println(n));
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(lv);
		
		
		

	}

}
