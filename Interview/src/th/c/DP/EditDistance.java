package th.c.DP;

public class EditDistance {

	public static int editDistance(String A, String B) {
		if(A == null || B == null) return -1;
		int lenA = A.length();
		int lenB = B.length();
		int[][] dp = new int[lenA+1][lenB+1];
		for(int i = 0; i <= lenA; i++) 
			dp[i][0] = i;
		for(int j = 0; j <= lenB; j++) 
			dp[0][j] = j;
		for(int i = 1; i <= lenA; i++) {
			for(int j = 1; j <= lenB; j++) {
				if(A.charAt(i-1) == B.charAt(j-1)) 
					dp[i][j] = dp[i-1][j-1];
				else 
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
			}
		}
		return dp[lenA][lenB];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(editDistance("kitten", "sitting"));
	}

}
