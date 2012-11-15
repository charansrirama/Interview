package th.c.PointToOffer;

public class FindMinimumInRotatedSorted {

	public static int findMinimum(int[] A) {
		if(A == null || A.length == 0) 
			throw new IllegalArgumentException();
		int l = 0, r = A.length-1;
		while(A[l] > A[r]) {
			int mid = l + (r-l)/2;
			if(A[mid] > A[r])
				l = mid+1;
			else 
				r = mid;
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
			System.out.println(findMinimum(A));	
			System.out.println(findMinimum(A2));
			System.out.println(findMinimum(A3));
	}

}
