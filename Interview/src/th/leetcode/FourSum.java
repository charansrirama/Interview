package th.leetcode;

import java.util.*;

// failed on large set
public class FourSum {
	public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (num.length < 4)
			return results;
		HashSet set = new HashSet();
		for (int i = 0; i < num.length - 3; i++) {
			for (int j = i + 1; j < num.length - 2; j++) {
				int start = j + 1;
				int end = num.length - 1;
				int left = target - num[i] - num[j];
				while (start < end) {
					int s = num[start] + num[end];
					if (s > left) {
						end--;
					} else if (s < left) {
						start++;
					} else {
						ArrayList<Integer> result = new ArrayList<Integer>();
						result.add(num[i]);
						result.add(num[j]);
						result.add(num[start]);
						result.add(num[end]);
						set.add(result);
						start++; end--;
					}
				}
			}
		}
		Iterator it = set.iterator();
		while (it.hasNext()) {
			results.add((ArrayList<Integer>) it.next());
		}
		return results;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1 0 -1 0 -2 2
		int[] array = new int[]{1,0,-1,0,-2,2};
		ArrayList<ArrayList<Integer>> results = fourSum(array, 0);
		for(ArrayList<Integer> re : results) {
			for(int i : re) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
