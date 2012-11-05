package th.c.Leetcode.DP;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(i >= j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        int maxLen = 0;
        int l = 0, r = 0;
        for(int k = 1; k < len; k++) {
            for(int i = 0; i+k < len; i++) {
                int j = i+k;
                if(s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i+1][j-1];
                    if(dp[i][j]) {
                        if(k+1 > maxLen) {
                            maxLen = k+1;
                            l = i;
                            r = j;
                        }
                    }
                }
            }
        }
        return s.substring(l, r+1);
    }
}
