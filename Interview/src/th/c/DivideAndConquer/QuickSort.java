package th.c.DivideAndConquer;

public class QuickSort {
	
	public int partition(int[] A, int left, int right) {
		int pivot = A[(left+right)/2];
		
		while (left <= right) {
			while(A[left] < pivot) left++;
			while(pivot < A[right]) right--;
			if(left <= right) {
				int temp = A[left];
				A[left] = A[right];
				A[right] = temp;
				left++; 
				right--;
			}
		}
		return left;
	}
	
	public void quickSort(int[] A, int left, int right) {
		int index = partition(A, left, right);
		if(left < index-1) {
			quickSort(A, left, index-1);
		}
		if(index < right) {
			quickSort(A, index, right);
		}
	}
	
	public static void main(String[] args) {
		int[] input = new int[] {2,3,1,6,4,5,11,33,10};
		QuickSort test = new QuickSort();
		test.quickSort(input, 0, input.length-1);
		for(int i : input) {
			System.out.print(i + " ");
		}
	}
}
