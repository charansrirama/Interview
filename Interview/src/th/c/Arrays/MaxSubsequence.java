package th.c.Arrays;

public class MaxSubsequence {

	public static int maxSequenceSum(int[] A) {
		if (A == null)
			return -1;
		int len = A.length;
		int max = Integer.MIN_VALUE;
		int running = 0;
		for (int i = 0; i < A.length; i++) {
			running += A[i];
			if (running > max)
				max = running;
			if (running < 0)
				running = 0;
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
