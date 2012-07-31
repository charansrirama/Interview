package amazon.leetcode;

public class JumpGameI {

	public boolean canJump(int[] A) {
		int k = A[0];
		int i = 1;
		for(; i <- k && i < A.length; i++) {
			if(k < A[k]+i) 
				k = A[i] + i;
		}
		return i>=A.length;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
