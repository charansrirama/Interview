package th.c.company.amzn;

public class LongestIncreaseSubsequence {
	
	// O(n2)
	public static int lis(int[] A) {
		int[] dp = new int[A.length];
		for(int i = 0; i < A.length; i++) {
			dp[i] = 1;
			for(int j = i-1; j >= 0; j--) {
				if(A[i] > A[j] && dp[j] + 1 > dp[i]) 
					dp[i] = dp[j] + 1;
			}
		}
		int max = 0;
		for(int i = 0; i < dp.length; i++) 
			max = dp[i] > max ? dp[i] : max;
		return max;
	}
	
	//O(n*lg(n))
	public static int lis2(int[] A) {
		int length = A.length;
		int[] b = new int[length];
		b[0] = A[0];
		int left, right, mid, len = 1;
		for(int i = 1; i < length; i++) {
			left = 0; right = len;
			while(left <= right) {
				mid = left + (right-left)/2;
				if(A[mid] > A[i]) right = mid-1;
				else left = mid+1;
			}
			b[left] = A[i];
			if(left > len) len++;
		}
		return len;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
