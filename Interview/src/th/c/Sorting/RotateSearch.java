package th.c.Sorting;

public class RotateSearch {
	
	public static int rotateSearch(int[] A, int x) {
		if(A == null || A.length == 0) return -1;
		return helper(A, 0, A.length-1, x);
	}
	
	public static int helper(int[] A, int left, int right, int x) {
		if(right < left) return -1;
		int mid = (left+right)/2;
		if(x == A[mid]) 
			return mid;
		if(A[left] < A[mid]) {
			if(x >= A[left] && x < A[mid]) {
				return helper(A, left, mid-1, x);
			} else {
				return helper(A, mid+1, right, x);
			}
		} else if(A[left] > A[mid]){
			if(x > A[mid] && x <= A[right]) {
				return helper(A, mid+1, right, x);
			} else {
				return helper(A, left, mid-1, x);
			}
		} else if(A[left] == A[mid]) {
			if(A[mid] != A[right]) {
				return helper(A, mid+1, right, x);
			} else {
				return helper(A, mid+1, right, x);
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = new int[]{2,2,2,3,4,2};
		System.out.println(rotateSearch(A, 3));
	}

}
