package th.c.Leetcode;

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
        if(A == null || A.length == 0) return -1;
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
