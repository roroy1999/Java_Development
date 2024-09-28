package com.learning.program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Collection_Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = new ArrayList<>();
		
		nums.add(1);
		nums.add(3);
		nums.add(2);
		
		System.out.println(nums);
		
		Collections.sort(nums);
		System.out.println(nums);
		
		Comparator<Integer> com = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				
				if(o1%10 > o2%10)
				  return 1;
				else
					return -1;
			}
		};
		List<Integer> nums1 = new ArrayList<>();
		
		nums1.add(12);
		nums1.add(18);
		nums1.add(21);
		
		Collections.sort(nums1, com);
		
		System.out.println(nums1);
		
		
	}

}
