package amazon.leetcode;

public class SearchInRotatedSortedArray {
	// AC
	private int binarySearch(int[] array, int low, int high, int target) {
		if(low <= high) {
			while(low <= high) {
				int mid = low+(high-low)/2;
				if(array[mid] == target) return mid;
				else if(array[mid] < target) low = mid+1;
				else high = mid-1;
			}
			return -1;
		} else {
			return -1;
		}
	}
	
	private int search(int[] A, int low, int high, int target) {
		if(low>=high) 
			return A[low]==target?low:-1;
		int mid = low+(high-low)/2;
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
	
	public int search(int[] A, int target) {
		return search(A, 0, A.length-1, target);
	}
	
	public static void main(String[] args) {
		int[] array = {3,1,1};
		SearchInRotatedSortedArray test = new SearchInRotatedSortedArray();
		System.out.println(test.search(array, 3));
	}
}
