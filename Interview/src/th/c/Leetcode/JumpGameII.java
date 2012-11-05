package th.c.Leetcode;

public class JumpGameII {

	// Greedy algorithm O(n)
	public int jump(int A[]) {
		int k = 0; // The position from where we could jump the farest so far
		int s = 0; // steps to jump
		int j = 0; // the last furtherest position we had checked
		int i = j+1; // index start to check
		int n = A.length;
		while(i < n) {
			i = j+1;
			int f = k + A[k];
			j = f;
			for(; i <= j && i < n; i++) {
				if(f <= (A[i]+i)) {
					k = i; 
					f = A[i] + i;
				}
			}
			s++;
		}
		return s;
	}
	
	public int jumpDP(int A[]) {
		if(A.length <= 1) return 0;
		int len = A.length;
		int[] dp = new int[len];
		dp[len-1] = 0;
		for(int i = len-2; i >= 0; i--) {
			int step = len;
			for(int j = 1; j <= A[i] && (i+j) < len; j++) {
				if(step > dp[i+j]) 
					step = dp[i+j];
			}
			dp[i] = step+1;
		}
		return dp[0];
	}
}
