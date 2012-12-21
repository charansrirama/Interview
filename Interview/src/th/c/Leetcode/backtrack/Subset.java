package th.c.Leetcode.backtrack;

import java.util.*;

public class Subset {

	// Bit version
	public ArrayList<ArrayList<Integer>> subsets2(int[] S) {
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << S.length;
		for(int k = 0; k < max; k++) {
			ArrayList<Integer> subset = convert(k, S);
			subsets.add(subset);
		}
		return subsets;
	}
	
	public ArrayList<Integer> convert(int x, int[] S) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		for(int k = x, index = 0; k > 0; k >>= 1, index++) {
			if((k & 1) == 1) {
				subset.add(S[index]);
			}
		}
		return subset;
	}
	
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
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
