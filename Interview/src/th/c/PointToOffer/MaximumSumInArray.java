package th.c.PointToOffer;

public class MaximumSumInArray {

	public static int findSum(int[] A) {
		int max = Integer.MIN_VALUE;
		int running = 0;
		for(int i = 0; i < A.length; i++) {
			running += A[i];
			if(running > max) 
				max = running;
			if(running < 0) 
				running = 0;
		}
		return max;
	}
	
	public static int findSumDP(int[] A) {
		if(A == null || A.length == 0) 
			throw new IllegalArgumentException();
		int[] dp = new int[A.length];
		dp[0] = A[0];
		int max = dp[0];
		for(int i = 1; i < A.length; i++) {
			if(dp[i-1] < 0) 
				dp[i] = A[i];
			else 
				dp[i] = dp[i-1] + A[i];
			if(dp[i] > max) 
				max = dp[i];
		}
		
		return max;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,-2,3,10,-4,7,2,-5};
		int[] B = {-1,-2,-3,-4};
		int[] C = {-1,-2,3};
		System.out.println(findSumDP(A));
		System.out.println(findSum(B));
		System.out.println(findSum(C));
	}

}
