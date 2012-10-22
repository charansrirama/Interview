package th.c.Leetcode;

public class JumpGame {

	public boolean canJump(int[] A) {
		int k = A[0];
		int i = 1;
		for(; i <= k && i < A.length; i++) {
			if(k < A[i] + i)
				k = A[i] + i;
		}
		return i == A.length;
	}
}
