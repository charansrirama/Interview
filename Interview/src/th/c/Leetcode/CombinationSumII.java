package th.c.Leetcode;

import java.util.*;

public class CombinationSumII {

	public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		HashSet<ArrayList<Integer>> tmp = new HashSet<ArrayList<Integer>>();
		help(num, new ArrayList<Integer>(), target, 0, 0, tmp);
		for(ArrayList<Integer> result : tmp) {
			results.add(result);
		}
		return results;
	}
	
	public static void help(int[] num, ArrayList<Integer> list, int target, int sum, int step, HashSet<ArrayList<Integer>> results) {
		if(sum == target) {
			ArrayList<Integer> result = new ArrayList<Integer>(list);
			results.add(result);
			//System.out.println(result);
		}
		if(sum >= target) return;
		for(int i = step; i < num.length; i++) {
			list.add(num[i]);
			help(num, list, target, sum+num[i], i+1, results);
			list.remove(list.size()-1);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num[] = new int[]{10,1,2,7,6,1,5};
		ArrayList<ArrayList<Integer>> result = combinationSum2(num, 8);
		for(ArrayList<Integer> al : result) {
			for(Integer i : al) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
