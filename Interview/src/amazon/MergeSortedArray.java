package amazon;

import java.util.Arrays;

// Dont know the input format of leetcode. 
// Try single input. AC
public class MergeSortedArray {
	public static void merge(int A[], int m, int B[], int n) {
		if(n==0) return;
		int iA = 0, iB = 0;
		while(iA < m - n) {
			if(A[iA] > B[iB]) {
				int tmp = A[iA];
				A[iA] = B[iB];
				B[iB] = tmp;
				iA++;
				Arrays.sort(B);
			} else {
				iA++;
			}
		}
		while(iB < n && iA < m) {
			A[iA++] = B[iB++];
		}
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {0};
		int[] B = new int[] {1};
		merge(A, 1, B, 1);
		th.util.Printer.arrayPrinter(A);
	}
	
}
