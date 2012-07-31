package amazon.leetcode;

import java.util.*;

public class CombinationSum {
	public static ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
	
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        int index[] = new int[candidates.length+1];
		index[0] = 0;
		solve(candidates, 0, target, candidates.length, index, 0);
		return results;
    }
	
	public static void solve(int[] candidates, int sum, int target, int size, int[] index, int step) {
		if(sum > target) 
			return;
		if(sum == target) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			for(int i = 1; i <= step; i++) {
				result.add(candidates[index[i]]);
			}
			results.add(result);
			return;
		}
		
		for(int i = index[step]; i < size; i++) {
			index[step+1] = i;
			solve(candidates, sum+candidates[i], target, size, index, step+1);
		}
    }
    
    public static void main(String args[]) {
    	combinationSum(new int[]{1,1}, 2);
    }
}
