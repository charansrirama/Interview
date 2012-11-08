package th.c.Arrays;

public class BinarySearch {

	public static int binarySearch(int[] A, int t) {
		if(A == null || A.length == 0) 
			throw new IllegalArgumentException();
		int l = 0, r = A.length-1;
		while(l <= r) {
			int mid = l + (r-l)/2;
			if(A[mid] == t) 
				return mid;
			else if(A[mid] > t) 
				r = mid - 1;
			 else 
				l = mid + 1;
		}
		return l;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,5,7,8,9,10};
		System.out.println(binarySearch(A, 2));
		System.out.println(binarySearch(A, 3));
		System.out.println(binarySearch(A, 6));
	}

}
