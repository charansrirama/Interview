package th.leetcode;

import java.util.ArrayList;

public class CombinationSum {
	
	public static void combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] index = new int[10000];
        index[0] = 0;
        solve(target, 0, candidates, candidates.length, index, 0);
    }
	
	public static void solve(int target, int sum, int[] candidates, int sz, int[] index, int n) {
		if(sum > target) return;
		if(sum == target) 
			printSum(candidates, index, n);
		
		for(int i = index[n]; i<sz; i++) {
			index[n+1] = i;
			solve(target, sum+candidates[i], candidates, sz, index, n+1);
		}
	}
	
	public static void printSum(int[] candidates, int[] index, int n) {
		for(int i = 1; i <= n; i++) {
			System.out.print(candidates[index[i]] + " ");
		}
		System.out.println();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = new int[]{2,3,6,7};
		combinationSum(data, 7);
	}

}
