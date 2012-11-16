package th.c.Leetcode;

public class RemoveDuplicateFromSortedArrayII {

	public int removeDuplicates(int[] A) {
		if(A == null) return 0;
		if(A.length <= 2) return A.length;
		int tail = 1; 
		int count = 1;
		for(int i = 1; i < A.length; i++) {
			if(A[i] == A[i-1]) {
				if(count < 2) {
					A[tail] = A[i];
					tail++;
					count++;
				}
			} else {
				A[tail] = A[i];
				tail++;
				count = 1;
			}
		}
		return tail;
	}
}
