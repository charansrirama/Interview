package th.c.Leetcode.DP;

public class DistinctSubsequences {
	
	// Recursion
	public int numDistinct1(String S, String T) {
		if(T.length() == 0) return 1;
		if(S.length() < T.length()) return 0;
		
		int ret = 0;
		
		if(S.charAt(0) == T.charAt(0)) 
			ret += numDistinct1(S.substring(1), T.substring(1));
		ret += numDistinct1(S.substring(1), T);
		return ret;
	}
	
	public static int numDistinct2(String S, String T) {
		if(T.length() == 0) 
			return 1;
		if(S.length() < T.length()) 
			return 0;
		int m = S.length();
		int n = T.length();
		
		int[][] dp = new int[m+1][n+1];
		for(int i = 0; i <= n; i++) {
			for(int j = i; j <= m; j++) {
				if(i == 0) {
					dp[j][i] = 1;
					continue;
				}
				if(S.charAt(m-j) == T.charAt(n-i)) 
					dp[j][i] = dp[j-1][i-1] + dp[j-1][i];
				else 
					dp[j][i] = dp[j-1][i];
			}
		}
		return dp[m][n];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "rabbbit";
		String T = "rabit";
		
		System.out.println(numDistinct2(S, T));
	}

}
