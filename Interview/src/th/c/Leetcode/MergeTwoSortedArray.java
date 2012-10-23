package th.c.Leetcode;

// AC
public class MergeTwoSortedArray {

	public void merge(int[] A, int m, int[] B, int n) {
		int index0 = 0;
		int index1 = 0;
		int max = m;
		while(index0 < max && index1 < n) {
			if(A[index0] < B[index1]) {
				index0++;
			} else {
				move(A, index0, max);
				A[index0++] = B[index1++];
				max++;
			}
		}
		while(index1 < n) {
			A[index0++] = B[index1++];
		}
	}
	
	// Move one step to back
	private void move(int[] A, int i, int m) {
		for(int j = m-1; j >= i; j--) {
			A[j+1] = A[j];
		}
	}
}
