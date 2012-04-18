package th.leetcode;

public class SearchRotatedSortedArray {
	
	public static int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		return search(A, 0, A.length-1, target);
        
    }
	
	public static int search(int[] A, int low, int high, int target) {
		if(low >= high) {
			return A[low] == target ? low : -1;
		}
		int mid = low + (high-low)/2;
		if(A[mid] == target) return mid;
		
		int sortedHalf = 0;
		if(A[low] < A[mid]) {
			sortedHalf = 1;
			if(A[low] <= target && target < A[mid]) {
				return binarySearch(A, low, mid-1, target);
			}
		}
		if(A[mid] < A[high]) {
			sortedHalf = 2;
			if(A[mid] < target && target <= A[high]) {
				return binarySearch(A, mid+1, high, target);
			}
		}
		if(sortedHalf == 2) {
			return search(A, low, mid-1, target);
		} else {
			return search(A, mid+1, high, target);
		}
	}
	
	public static int binarySearch(int[] a, int low, int high, int x) {
		if(low <= high) {
			int middle = low + (high - low)/2;
			int result = -1;
			if(a[middle] == x) {
				result = middle;
			} else if(x < a[middle]){
				result = binarySearch(a, low, middle-1, x);
			} else if(a[middle] < x) {
				result = binarySearch(a, middle+1, high, x);
			}
			return result;
		} else {
			return -1;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = new int[]{1,3};
		System.out.println(search(data, 3));
	}

}
