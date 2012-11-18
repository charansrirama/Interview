package th.c.Leetcode.DP;

public class UniquePathII {
	public int uniquePaths(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if(m == 1 && n == 1) return obstacleGrid[0][0] == 1 ? 0 : 1;
		if(obstacleGrid[m-1][n-1] == 1) return 0;
		int[] dp = new int[n];
		dp[n-1] = 1;
		for(int i = n-2; i >= 0; i--) {
			if(obstacleGrid[m-1][i] == 1) {
				dp[i] = 0;
				break;
			} else {
				dp[i] = dp[i+1];
			}
		}
		for(int i = m-2; i >= 0; i--) {
			for(int j = n-1; j >= 0; j--) {
				if(j == n-1) {
					if(obstacleGrid[i][j] == 1) dp[j] = 0;
				} else {
					if(obstacleGrid[i][j] == 1) dp[j] = 0;
					else dp[j] = dp[j]+dp[j+1];
				}
			}
		}
		return dp[0];
	}
}
