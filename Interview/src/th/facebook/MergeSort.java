package th.facebook;

public class MergeSort {

	public static void mergeSort(int[] A) {
		mergeSort(A, 0, A.length-1);
	}
	
	private static void mergeSort(int[] A, int left, int right) {
		if(left >= right) return;
		int mid = (left+right)/2;
		mergeSort(A, left, mid);
		mergeSort(A, mid+1, right);
		
		merge(A, left, mid, right);
	}
	
	private static void merge(int[] A, int left, int mid, int right) {
		int tmp[] = new int[right-left+1];
		int i = 0, i1 = left, i2 = mid+1;
		while(i1 <= mid && i2 <= right) {
			if(A[i1] > A[i2]) {
				tmp[i] = A[i2];
				i2++;
			} else if(A[i1] <= A[i2]) {
				tmp[i] = A[i1];
				i1++;
			}
			i++;
		}
		while(i1 <= mid) {
			tmp[i] = A[i1];
			i++; i1++;
		}
		while(i2 <= right) {
			tmp[i] = A[i2];
			i++; i2++;
		}
		for(int j = 0; j < tmp.length; j++) {
			A[j+left] = tmp[j];
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = new int[]{4,6,3,77,1,8,9,10};
		mergeSort(A);
		th.util.Printer.arrayPrinter(A);
	}

}
