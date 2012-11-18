package th.c.Leetcode.DP;

import java.util.*;

public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int len = triangle.get(triangle.size()-1).size();
		int[] dp = new int[len];
		dp[0] = triangle.get(0).get(0);
		for(int i = 1; i < triangle.size(); i++) {
			ArrayList<Integer> tmp = triangle.get(i);
			for(int j = i; j > 0; j--) {
				if(j == i) dp[j] = dp[j-1] + (Integer)tmp.get(j);
				else {
					dp[j] = Math.min(dp[j], dp[j-1]) + (Integer)tmp.get(j);
				}
			}
			dp[0] = dp[0] + (Integer)tmp.get(0);
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < dp.length; i++) 
			if(dp[i] < min) min = dp[i];
		return min;
	}
}
