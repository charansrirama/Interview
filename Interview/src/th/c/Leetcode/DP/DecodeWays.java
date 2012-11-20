package th.c.Leetcode.DP;

import java.util.ArrayList;

public class DecodeWays {
	
	public static int numDecodings(String s) {
		ArrayList<String> results = new ArrayList<String>();
		helper(s, "", results);
		
		return results.size();
    }

	public static void helper(String s, String re, ArrayList<String> results) {
		if(s.length() == 0) {
			if(re.length() != 0)
				results.add(re);
		} else {
			int v = Character.getNumericValue(s.charAt(0));
			if(v >= 1 && v <= 9) {
				re += (char)(v+64);
				helper(s.substring(1), re, results);
			} 
			if(s.length() >= 2) {
				int v1 = Character.getNumericValue(s.charAt(0));
				int v2 = Character.getNumericValue(s.charAt(1));
				if((v1 == 1 && v2 >= 0 && v2 <= 9)|| (v1 == 2 && v2 >= 0 && v2 <= 6)) {
					re += (char)(v1*10+v2+64);
					helper(s.substring(2), re, results);
				}
			}
		}
	}
	
	// AC
	public int numDecodingsDP(String s) {
		if(s == null || s.length() == 0) return 0;
		int len = s.length();
		int[] dp = new int[len+1];
		dp[len] = 1;
		for(int i = len-1; i>=0; i--) {
			if(s.charAt(i) != '0') {
				dp[i] = dp[i+1];
				if(i < len-1 && Integer.parseInt(s.substring(i, i+2)) <= 26) {
					dp[i] += dp[i+2];
				}
			}
		}
		return dp[0];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
