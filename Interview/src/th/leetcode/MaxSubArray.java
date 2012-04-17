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
}
