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
	
	public static ArrayList<ArrayList<Integer>> fourSum2(int[] array) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if(array.length < 4) return results;
		int len = array.length;
		Map<Integer, Pair> map = new HashMap<Integer, Pair>();
		
		for(int i = 0; i < len; i++) {
			for(int j = i+1; j < len; j++) {
				map.put(array[i] + array[j], new Pair(i, j));
			}
		}
		
		for(int i = 0; i < len; i++) {
			for(int j = i+1; j < len; j++) {
				int sum = array[i] + array[j];
				int res = 0 - sum;
				if(map.containsKey(res)) {
					Pair p = map.get(res);
					ArrayList<Integer> result = new ArrayList<Integer>();
					result.add(array[i]);
					result.add(array[j]);
					result.add(array[p.x]);
					result.add(array[p.y]);
//					System.out.println(array[i] + " " + array[j] + " " + array[p.x] + " " + array[p.y]);
				}
			}
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
		
		int num[]={1,2,3,4,12,43,32,53,8,-10,4};
		fourSum2(num);
	}
}

class Pair {
	int x;
	int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
