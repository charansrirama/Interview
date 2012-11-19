package th.c.Leetcode;

public class SearchInRotatedSortedArray {
	
	public int search(int[] A, int target) {
		return search(A, 0, A.length-1, target);
    }
	
	private int search(int[] A, int low, int high, int target) {
		if(low >= high) return A[low] == target ? low : -1;
		int mid = low + (high-low)/2;
		if(A[mid] == target) return mid;
		int sortedHalf = 0;
		if(A[low] < A[mid]) {
			sortedHalf = 1;
			if(A[low] <= target && target < A[mid]) 
				return binarySearch(A, low, mid-1, target);
		}
		if(A[mid] < A[high]) {
			sortedHalf = 2;
			if(A[mid] < target && target <= A[high])
				return binarySearch(A, mid+1, high, target);
		}
		if(sortedHalf == 2) 
			return search(A, low, mid-1, target);
		else 
			return search(A, mid+1, high, target);
	}
	
	private int binarySearch(int[] A, int low, int high, int target) {
		if(low <= high) {
			while(low <= high) {
				int mid = low + (high-low)/2;
				if(A[mid] == target) return mid;
				else if(A[mid] > target) high = mid-1;
				else low = mid+1;
			}
			return -1;
		} else 
			return -1;
	}
}
