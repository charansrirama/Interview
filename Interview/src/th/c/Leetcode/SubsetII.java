package th.c.Leetcode;

import java.util.*;

public class SubsetII {
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
