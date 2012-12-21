package th.c.Leetcode.backtrack;

import java.util.*;

public class SubsetII {
	
	// Only drawback for this method is the value of prev. 
	ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> subsetsWithDup2(int[] S) {
		if(S == null || S.length == 0) return subsets;
		Arrays.sort(S);
		help(new ArrayList<Integer>(), S, 0);
		return subsets;
	}
	
	public void help(ArrayList<Integer> subset, int[] S, int step) {
		subsets.add(new ArrayList<Integer>(subset));
		int prev = Integer.MIN_VALUE;
		for(int i = step; i < S.length; i++) {
			if(S[i] != prev) {
				subset.add(S[i]);
				help(subset, S, i+1);
				subset.remove(subset.size()-1);
				prev = S[i];
			}
		}
	}
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if(S == null || S.length == 0) return results;
		Arrays.sort(S);
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		helper(set, new ArrayList<Integer>(), S, 0);
		return new ArrayList<ArrayList<Integer>>(set);
	}
	
	public void helper(HashSet<ArrayList<Integer>> set, ArrayList<Integer> list, int[] S, int j) {
		if(set.contains(list)) return;
		else {
			set.add(new ArrayList<Integer>(list));
			for(int i = j; i < S.length; i++) {
				list.add(S[i]);
				helper(set, list, S, i+1);
				list.remove(list.size()-1);
			}
		}
	}
}
