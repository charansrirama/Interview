package th.c.Sorting;

public class BinarySearch {
	
	public static int binarySearch(int[] A, int t) {
		int left = 0; 
		int right = A.length - 1;
		while(left <= right) {
			int mid = (left + right)/2;
			if(A[mid] == t) 
				return mid;
			else if(A[mid] > t) 
				right = mid -1;
			else 
				left = mid +1;
		}
		return left;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1,2,3,4,6,7,8};
		System.out.println(binarySearch(A, 5));
	}

}
