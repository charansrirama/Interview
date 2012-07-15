package amazon;

import java.util.*;

public class CombinationSum2 {

	public static ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
	public static HashSet<ArrayList<Integer>> sets = new HashSet<ArrayList<Integer>>();
	
	public static void solve(int[] num, int target, ArrayList<Integer> list, int index) {
		int s = 0;
		for(Integer i : list) {
			s += i;
		}
		if(s == target) {
			ArrayList<Integer> result = new ArrayList<Integer>(list);
			sets.add(result);
		}
		if(s >= target) return;
		for(int i = index; i < num.length; i++) {
			list.add(num[i]);
			solve(num, target, list, i+1);
			list.remove(list.size()-1);
		}
	}
	
	public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		java.util.Arrays.sort(num);
		solve(num, target, new ArrayList<Integer>(), 0);
		for(ArrayList<Integer> list : sets) {
			results.add(list);
		}
		return results;
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
