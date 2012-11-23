package th.c.Leetcode.backtrack;

import java.util.*;

// Use multiple times
public class CombinationSum {

	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candicates, int target) {
		if(candicates == null) return null;
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		int[] index = new int[target+1];
		Arrays.fill(index, -1);
		index[0] = 0;
		help(candicates, index, target, 0, candicates.length, 0, results);
		return results;
	}
	
	public static void help(int[] candicates, int[] index, int target, int sum, int length, int step, ArrayList<ArrayList<Integer>> results) {
		if(sum == target) {
			ArrayList<Integer> result = new ArrayList<Integer>(); 
			for(int i = 1; i <= step; i++) {
				result.add(candicates[index[i]]);
			}
			results.add(result);
		}
		if(sum >= target) return;
		for(int i = index[step]; i < length; i++) {
			index[step+1] = i;
			help(candicates, index, target, sum+candicates[i], length, step+1, results);
			index[step+1] = -1;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> results = combinationSum(new int[]{1,2,3,6,7}, 7);
		for(ArrayList<Integer> result : results) {
			System.out.println(result);
		}
	}

}
