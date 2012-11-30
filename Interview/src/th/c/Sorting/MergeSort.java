package th.c.Sorting;

public class MergeSort implements Sort {

	private static int[] aux;
	@Override
	public void sort(int[] array) {
		// TODO Auto-generated method stub
		if(array == null) return;
		aux = new int[array.length];
		sort(array, 0, array.length-1);
	}
	
	private void sort(int[] A, int low, int hi) {
		if(low >= hi) return;
		int mid = low + (hi - low)/2;
		sort(A, low, mid);
		sort(A, mid+1, hi);
		merge(A, low, mid, hi);
	}
	
	private void merge(int[] A, int low, int mid, int hi) {
		int i = low, j = mid+1;
		for(int k = low; k <= hi; k++) aux[k] = A[k];
		for(int k = low; k <= hi; k++) {
			if(i > mid) A[k] = aux[j++];
			else if(j > hi) A[k] = aux[i++];
			else if(aux[j] < aux[i]) A[k] = aux[j++];
			else A[k] = aux[i++];
		}
	}
}
