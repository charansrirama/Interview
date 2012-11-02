package th.c.Arrays;

public class MinimumInRotatedSortedArray {
	
	public static int findMinimumInRotatedSortedArray(int[] A) {
		if(A == null || A.length == 0) return -1;
		int l = 0;
		int r = A.length-1;
		while(A[l] > A[r]) {
			int mid = l + (r-l)/2;
			if(A[mid] > A[r]) {
				l = mid+1;
			} else {
				r = mid;
			}
		}
		return l;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {
			3,4,5,6,7,0,1,2	
		};
		int[] A2 = {
				2,3,4,5,6,7,0,1	
		};
		int[] A3 = {
				3,4,5,1,2	
		};
		System.out.println(findMinimumInRotatedSortedArray(A));	
		System.out.println(findMinimumInRotatedSortedArray(A2));
		System.out.println(findMinimumInRotatedSortedArray(A3));
	}

}
