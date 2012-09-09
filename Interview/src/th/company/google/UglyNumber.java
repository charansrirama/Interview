package th.company.google;

public class UglyNumber {
	
	// 0 is Ugly Number
	
	// Method 1
	public static int maxDivide(int a, int b) {
		while(a%b == 0) 
			a = a/b;
		return a;
	}

	public static boolean isUgly(int num) {
		num = maxDivide(num, 2);
		num = maxDivide(num, 3);
		num = maxDivide(num, 5);
		num = maxDivide(num, 7);
		
		return num == 1 ? true : false;
	}
	
	public static int getNthUgly(int N) {
		if(N == 1) return 0;
		int i = 1;
		int count = 2;
		while(count < N) {
			i++;
			if(isUgly(i)) 
				count++;
		}
		return i;
	}
	
	// DP way
	public static long min(long a, long b, long c, long d) {
		return (a<b) ? ((a<c) ? ((a<d) ? a : d ): ((c < d) ? c: d)) : ((b<c)? ((b<d) ? b : d) : ((c<d) ? c : d));
	}
	
	public static long getNthUglyDP(int N) {
		if(N == 1) return 0;
		long[] dp = new long[N];
		dp[0] = 0; 
		dp[1] = 1;
		
		int i2 = 1, i3 = 1, i5 = 1, i7 = 1;
		for(int i = 2; i < N; i++) {
			long prev = dp[i-1];
			while(dp[i2]*2 <= prev) i2++;
			while(dp[i3]*3 <= prev) i3++;
			while(dp[i5]*5 <= prev) i5++;
			while(dp[i7]*7 <= prev) i7++;
			
			long next2 = dp[i2] * 2;
			long next3 = dp[i3] * 3;
			long next5 = dp[i5] * 5;
			long next7 = dp[i7] * 7;
			dp[i] = min(next2, next3, next5, next7);
		}
		return dp[N-1];
	}
	
	// Code Jam
	public static long uglyNumber(String S) {
		int mod = 2*3*5*7;
		long[][] dp = new long[41][mod];
		dp[0][0] = 1;
		int prob = 1;
		for(int i = 0; i < S.length(); i++) {
			for(int sgn = (i==0) ? 1 : -1; sgn <= 1; sgn += 2) {
				int cur = 0;
				for(int j = i; j < S.length(); j++) {
					cur = (cur*10 + S.charAt(j)-'0')%mod;
					for(int x = 0; x < mod; x++) {
						dp[j+1][(x+sgn*cur+mod)%mod] += dp[i][x];
					}
				}
			}
		}
		long ret = 0;
		for(int x = 0; x < mod; x++) {
			if(x%2 == 0 || x%3 == 0 || x%5 == 0 || x%7 == 0) 
				ret += dp[S.length()][x];
		}
		System.out.println(ret);
		return ret;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(getNthUgly(150));
		//System.out.println(getNthUglyDP(150));
		
		uglyNumber("12345");
	}

}
