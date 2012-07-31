package amazon.leetcode;

public class MaximalSubarray {

	// AC
	public int maxSubArray(int[] A) {
		int max = Integer.MIN_VALUE;
		int running = 0;
		for(int i = 0; i < A.length; i++) {
			running += A[i];
			if(running > max) {
				max = running;
			} 
			if(running < 0) {
				running = 0;
			}
		}
		return max;
	}

}
