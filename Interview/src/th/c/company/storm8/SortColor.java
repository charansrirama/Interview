package th.c.company.storm8;

public class SortColor {

	public static void sortColor(int[] A) {
		if(A == null || A.length == 0) return;
		int l = 0, r = A.length-1;
		for(int i = 0; i <= r;) {
			if(A[i] == 0) {
				swap(A, i++, l++);
			} else if(A[i] == 1) {
				i++;
			} else if(A[i] == 2) {
				swap(A, i, r--);
			} else {
				throw new IllegalArgumentException();
			}
		}
	}
	
	public static void swap(int[] A, int i, int j) {
		A[i] ^= A[j];
		A[j] ^= A[i];
		A[i] ^= A[j];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 0, 1, 2, 1, 2, 1, 2, 0, 0, 2, 1, 0, 0, 2, 2, 1, 0 };
		sortColor(arr);
		for(int i : arr) 
			System.out.print(i+ " ");
	}

}
