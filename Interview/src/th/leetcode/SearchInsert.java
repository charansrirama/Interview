package th.leetcode;

public class SearchInsert {

	public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int low = 0;
		int high = A.length-1;
		int mid;
		while(true) {
			mid = (low+high)/2;
			if(low>=high) break;
			if(A[mid] < target)
				low = mid+1;
			else 
				high = mid;
		}
		return mid;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
