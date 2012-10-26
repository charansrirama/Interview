package th.c.DivideAndConquer;

public class MergeSort {

	public void mergeSort(int[] A, int left, int right) {
		if(left < right) {
			int mid = (left+right)/2;
			mergeSort(A, left, mid);
			mergeSort(A, mid+1, right);
			merge(A, left, mid, right);
		}
	}
	
	public void merge(int[] A, int left, int mid, int right) {
		int[] B = new int[right-left+1];
		int i = left, j = mid+1;
		int k = 0;
		while(i <= mid && j <= right) {
			if(A[i] <= A[j]) {
				B[k] = A[i];
				i++;
			} else {
				B[k] = A[j];
				j++;
			}
			k++;
		}
		while(i <= mid) {
			B[k++] = A[i++];
		}
		while(j <= right) {
			B[k++] = A[j++];
		}
		for(k = 0; k < B.length; k++) {
			A[left+k] = B[k];
		}
	}
	
	public static void main(String[] args) {
		int[] input = new int[] {2,3,1,6,4,5,11,33,10};
		MergeSort test = new MergeSort();
		test.mergeSort(input, 0, input.length-1);
		for(int i : input) {
			System.out.print(i + " ");
		}
	}
}
