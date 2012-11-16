package th.c.Leetcode;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		int tail = 0;
		for(int i = 0; i < A.length; i++) {
			if(A[i] != elem) {
				A[tail] = A[i];
				tail++;
			}
		}
		return tail;
	}
}
