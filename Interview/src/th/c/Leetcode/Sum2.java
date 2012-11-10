package th.c.Leetcode;

import java.util.*;

public class Sum2 {
	public int[] twoSum(int[] numbers, int target) {
		int[] re = new int[2];
		Hashtable<Integer, Integer> mapping = new Hashtable<Integer, Integer>();
		if(numbers.length < 2) return re;
		for(int i = 0; i < numbers.length; i++) {
			if(mapping.containsKey(numbers[i])) {
				re[0] = mapping.get(numbers[i]) + 1;
				re[1] = i + 1;
				return re;
			} else {
				mapping.put(target - numbers[i], i);	
			}
		}
		return null;
    }
}
