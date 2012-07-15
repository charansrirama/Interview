package th.leetcode;

public class MaxSubArray {
	public int maxSubArray(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int maxSum = 0;
		int runningSum = 0;

		int maxNeg = Integer.MIN_VALUE;

		for (int i = 0; i < A.length; i++) {
			runningSum += A[i];
			if (runningSum > maxSum)
				maxSum = runningSum;
			if (runningSum <= 0) {
				if (runningSum > maxNeg) {
					maxNeg = runningSum;
				}
				runningSum = 0;
			}

		}

		if (maxSum == 0) {
			maxSum = maxNeg;
		}
		return maxSum;
	}
	
	// This is better, more clear
	public int maxSubArray2(int[] A) {
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
