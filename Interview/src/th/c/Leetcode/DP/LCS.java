package th.c.Leetcode.DP;

public class LCS {
	
	public static String lcs(String x, String y) {
		int lenx = x.length();
		int leny = y.length();
		int[][] dp = new int[lenx+1][leny+1];
		String[][] path = new String[lenx+1][leny+1];
		for(int i = 1; i <= lenx; i++) {
			for(int j = 1; j <= leny; j++) {
				if(x.charAt(i-1) == y.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
					path[i][j] = "\\";
				} else if(dp[i-1][j] >= dp[i][j-1]) {
					dp[i][j] = dp[i-1][j];
					path[i][j] = "|";
				} else {
					dp[i][j] = dp[i][j-1];
					path[i][j] = "-";
				}
			}
		}
		StringBuilder result = new StringBuilder();
		print(path, x, result, lenx, leny);
		return result.toString();
	}

	public static void print(String[][] path, String x, StringBuilder result, int i, int j) {
		if(i==0 || j == 0) return;
		else if(path[i][j].equals("\\")) {
			print(path, x, result, i-1, j-1);
			result.append(x.charAt(i-1));
		} else if(path[i][j].equals("|")) {
			print(path, x, result, i-1, j);
		} else {
			print(path, x, result, i, j-1);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lcs("ABCBDAB", "BDCABA"));
	}

}
