package th.c.Leetcode;

import java.util.*;

public class Sum4 {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	if(num.length < 4) 
			return results;
		
		Arrays.sort(num);
		for(int i = 0; i < num.length - 3; i++) {
			for(int j = i+1; j < num.length - 2; j++) {
				int start = j + 1;
				int end = num.length - 1;
				int left = target - num[i] - num[j];
				while(start < end) {
					int s = num[start] + num[end];
					if(s > left) {
						end--;
					} else if(s < left) {
						start++;
					} else {
						ArrayList<Integer> result = new ArrayList<Integer>();
						result.add(num[i]);
						result.add(num[j]);
						result.add(num[start]);
						result.add(num[end]);
						results.add(result);
						while(start+1 < end && num[start] == num[start+1]) {
							start++;
						}
						start++;
					}
				}
				while(j+1 < num.length && num[j] == num[j+1]) {
					j++;
				}
			}
			while(i+1 < num.length && num[i] == num[i+1]){
				i++;
			}
		}
		return results;
    }
}
