package th.c.Leetcode;

import java.util.*;

public class Sum3 {

	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length == 0) return results;
		
		Arrays.sort(num);
		for(int i = 0; i < num.length-2; i++) {
			int left = 0 - num[i];
			int l = i+1, r = num.length-1;
			while(l < r) {
				int sum = num[l] + num[r];
				if(sum > left) {
					r--;
				} else if(sum < left) {
					l++;
				} else {
					ArrayList<Integer> result = new ArrayList<Integer>();
					result.add(num[i]);
					result.add(num[l]);
					result.add(num[r]);
					results.add(result);
					while(l < r && num[l] == num[l+1]) l++;
					l++;
				}
			}
			while(i+1 < num.length && num[i+1] == num[i]) i++;
		}
		return results;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
