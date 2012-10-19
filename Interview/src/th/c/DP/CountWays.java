package th.c.DP;

import java.util.HashMap;

public class CountWays {

	public static long countWays(int n) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		if(n == 3) return 4;
		
		long[] dp = new long[n];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 4;
		for(int i = 3; i < n; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		return dp[n-1];
	}
	
	public static long countWaysDP(int n, HashMap<Integer, Long> map) {
		if(map.containsKey(n))
			return map.get(n);
		long q = 0;
		if(n < 0) return 0;
		if(n == 0) {
			q = 1;
		} else {
			q = countWaysDP(n-1, map) + countWaysDP(n-2, map) + countWaysDP(n-3, map);
		}
		map.put(n, q);
		return q;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countWays(100));
		System.out.println(countWaysDP(100, new HashMap<Integer, Long>()));
	}

}
