package th.c.Leetcode;

// AC
public class MinimumPathSum {

	// Time: O(mn) Space: O(min(m, n))
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		if (n < m) {
			int[] dp = new int[n];
			dp[n-1] = grid[m-1][n-1];
			for(int i = n-2; i >= 0; i--) {
				dp[i] = grid[m-1][i] + dp[i+1];
			}
			for(int i = m-2; i >= 0; i--) {
				for(int j = n-1; j >= 0; j--) {
					if(j == n-1) {
						dp[j] += grid[i][j];
					} else {
						dp[j] = grid[i][j] + Math.min(dp[j], dp[j+1]);
					}
				}
			}
			return dp[0];
		} else {
			int[] dp = new int[m];
			dp[m-1] = grid[m-1][n-1];
			for(int i = m-2; i >= 0; i--) {
				dp[i] = grid[i][n-1] + dp[i+1];
			}
			for(int i = n-2; i >= 0; i--) {
				for(int j = m-1; j >= 0; j--) {
					if(j == m-1) {
						dp[j] += grid[j][i];
					} else {
						dp[j] = grid[j][i] + Math.min(dp[j], dp[j+1]);
					}
				}
			}
			return dp[0];
		}
	}
}
