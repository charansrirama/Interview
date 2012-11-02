package th.c.String;

public class Palindrome {

	public static String findLongestPalidrome(String s) {
		if(s.length() <= 1)
			return s;
		int len = s.length();
		boolean[][] dp = new boolean[len][len];
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				if(i >= j) 
					dp[i][j] = true;
				else 
					dp[i][j] = false;
			}
		}
		int maxLen = 1;
		int rf = 0, rt = 0;
		for(int k = 1; k < len; k++) {
			for(int i = 0; i + k < len; i++) {
				int j = i+k;
				if(s.charAt(i) != s.charAt(j)) {
					dp[i][j] = false;
				} else {
					dp[i][j] = dp[i+1][j-1];
					if(dp[i][j]) {
						if(k+1 > maxLen) {
							maxLen = k+1;
							rf = i; 
							rt = j;
						}
					}
				}
			}
		}
		return s.substring(rf, rt+1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
