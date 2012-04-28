package th.leetcode;

public class JumpGame {
	
	public static boolean canJump(int[] A) {
		int k = A[0];
		int i = 1;
		while(i <= k && i < A.length) {
			if(k < A[i]+i) k = A[i]+i;
			i++;
		}
		return i >= A.length;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
