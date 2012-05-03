package th.facebook;

import java.util.*;

public class CombinationSum {
	public static ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
	
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int index[] = new int[candidates.length+1];
		index[0] = 0;
		solve(candidates, 0, target, candidates.length, index, 0);
		return results;
    }
	
	public static void solve(int[] candidates, int sum, int target, int size, int[] index, int n) {
		if(sum > target) 
			return;
		if(sum == target) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			for(int i = 1; i <= n; i++) {
				result.add(candidates[index[i]]);
			}
			results.add(result);
			return;
		}
		
		for(int i = index[n]; i < size; i++) {
			index[n+1] = i;
			solve(candidates, sum+candidates[i], target, size, index, n+1);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = new int[]{2,3,6,7};
		ArrayList<ArrayList<Integer>> results = combinationSum(data, 7);
		for(ArrayList<Integer> r : results) {
			for(Integer i : r) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
