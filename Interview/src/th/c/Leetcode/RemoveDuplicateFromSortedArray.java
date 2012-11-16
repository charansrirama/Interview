package th.c.Leetcode;

public class RemoveDuplicateFromSortedArray {
	public int removeDuplicates(int[] A) {
		if(A == null) return 0;
		if(A.length <= 1) return A.length;
		int tail = 1;
		for(int i = 1; i < A.length; i++) {
			if(A[i] != A[i-1]) {
				A[tail] = A[i];
				tail++;
			}
		}
		return tail;
	}
}
