package th.facebook;

public class SquishedStatus {

	public static long squishedStatus(int M, String s) {
		char[] seq = s.toCharArray();
		long[] dp = new long[seq.length+1];
		dp[seq.length] = 1;
		for(int i = seq.length-1; i>=0; i--) {
			dp[i] = (((single(seq[i]-'0', M))?dp[i+1]:0) + 
					((i<seq.length-1&&tens(seq[i]-'0', seq[i+1]-'0', M))?dp[i+2]:0) + 
					((i<seq.length-2&&hundreds(seq[i]-'0', seq[i+1]-'0', seq[i+2]-'0', M))?seq[i+3]:0))%4207849484L;
		}
		return dp[0];
	}
	
	public static boolean single(int x, int M) {
		if(x == 0 || x > M) return false;
		return true;
	}
	
	public static boolean tens(int x0, int x1, int M) {
		if((x1 + 10*x0) > M || x0 == 0) return false;
		return true;
	}
	
	public static boolean hundreds(int x0, int x1, int x2, int M) {
		if((x2 + 10*x1 + 100*x0) > M || x0 == 0) return false;
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
