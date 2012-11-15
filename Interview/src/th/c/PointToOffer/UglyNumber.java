package th.c.PointToOffer;

public class UglyNumber {

	private int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}
	
	public int getUglyNumber(int n) {
		if(n <= 0) return 0;
		int[] dp = new int[n];
		int i2 = 0, i3 = 0, i5 = 0;
		dp[0] = 1;
		int nextUgly = 1;
		int next2 = 2, next3 = 3, next5 = 5;
		for(int i = 1; i < n; i++) {
			nextUgly = min(next2, next3, next5);
			dp[i] = nextUgly;
			if(nextUgly == next2) {
				i2++;
				next2 = dp[i2]*2;
			} else if(nextUgly == next3) {
				i3++;
				next3 = dp[i3]*3;
			} else if(nextUgly == next5) {
				i5++;
				next5 = dp[i5]*5;
			}
		}
		return nextUgly;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
