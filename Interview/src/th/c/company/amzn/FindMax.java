package th.c.company.amzn;

public class FindMax {

	public static int findMax(int[] A) {
		if(A == null || A.length == 0) return -1;
		int l = 0, r = A.length-1;
		while(l < r) {
			int mid = l + (r-l)/2;
			if(mid < A.length && A[mid] < A[mid+1]) 
				l = mid+1;
			else if(mid > 0 && A[mid] < A[mid-1]) 
				r = mid-1;
			else 
				return A[mid];
		}
		return A[l];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A0 = {1,2,3,4,5,6,5,4,3,2,1};
		int[] A1 = {1,2,3,4,5,6,5,4,3,2};
		int[] A2 = {5,6,5,4,3,2,1};
		int[] A3 = {6,5,4,3,2,1};
		int[] A4 = {1,2,3,4,5,6};
		System.out.println(findMax(A0));
		System.out.println(findMax(A1));
		System.out.println(findMax(A2));
		System.out.println(findMax(A3));
		System.out.println(findMax(A4));
	}

}
