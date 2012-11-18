package th.c.Leetcode.DP;

import java.util.Arrays;

public class UniquePath {
	
	public int uniquePaths(int m, int n) {
		if(m <= 0 && n <= 0) return 0;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for(int i = m-2; i>= 0; i--) {
			for(int j = n-2; j >= 0; j--) {
				dp[j] = dp[j]+dp[j+1];
			}
		}
		return dp[0];
	}
	
	public int uniquePaths2(int m, int n) {
		if(m <= 0 && n <= 0) return 0;
		int[][] dp = new int[m][n];
		dp[m-1][n-1] = 1;
		for(int i = m-2; i >= 0; i--) 
			dp[i][n-1] = dp[i+1][n-1];
		for(int i = n-2; i >= 0; i--) 
			dp[m-1][i] = dp[m-1][i+1];
		for(int i = m-2; i >= 0; i--) {
			for(int j = n-2; j >= 0; j--) {
				dp[i][j] = dp[i+1][j] + dp[i][j+1];
			}
		}
		return dp[0][0];
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
