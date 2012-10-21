package th.c.Recursion;

import java.util.*;

public class MakeChange {
	public static ArrayList<ArrayList<Integer>> makeChange(int[] money,
			int target) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		int[] index = new int[target+1];
		index[0] = 0;
		helper(money, index, target, 0, money.length, 0, results);
		return results;
	}

	private static void helper(int[] money, int[] index, int target, int sum,
			int length, int step, ArrayList<ArrayList<Integer>> results) {
		if(sum == target) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			for(int i = 1; i <= step; i++) {
				result.add(money[index[i]]);
			}
			results.add(result);
		}
		if(sum >= target) return;
		for(int i = index[step]; i < length; i++) {
			index[step+1] = i;
			helper(money, index, target, sum+money[i], length, step+1, results);
			index[step+1] = -1;
		}
	}
}
