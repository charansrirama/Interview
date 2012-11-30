package th.c.Sorting;

public class QuickSort implements Sort {

	@Override
	public void sort(int[] array) {
		// TODO Auto-generated method stub
		if(array == null) return;
		sort(array, 0, array.length-1);
	}
	
	private void sort(int[] A, int lo, int hi) {
		if(lo >= hi) return;
		int j = partition(A, lo, hi);
		sort(A, lo, j-1);
		sort(A, j+1, hi);
	}

	private int partition(int[] A, int lo, int hi) {
		int i = lo, j = hi+1;
		int v = A[lo];
		while(true) {
			while(A[++i] < v) if(i == hi) break;
			while(A[--j] > v) if(j == lo) break;
			if(i >= j) break;
			swap(A, i, j);
		}
		swap(A, j, lo);
		return j;
	}
	
	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
