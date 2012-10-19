package th.c.Recursion;

import java.util.*;

public class Subset {
	
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allSets;
		if(index == set.size()) {
			allSets = new ArrayList<ArrayList<Integer>>();
			allSets.add(new ArrayList<Integer>());
		} else {
			allSets = getSubsets(set, index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moreSubset = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset : allSets) {
				ArrayList<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(subset);
				newSubset.add(item);
				moreSubset.add(newSubset);
			}
			allSets.addAll(moreSubset);
		}
		return allSets;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
