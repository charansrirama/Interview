package th.array;

public class CircularArraySearch {
	
	public static int circularArraySearch(int[] a, int low, int high, int x) {
		int mid = low + (high-low)/2;
		if(a[mid] == x) return mid;
		
		int sortedHalf = 0;
		if(a[low] <= a[mid]) {
			sortedHalf = 1;
			if(a[low] <= x && x <= a[mid]) {
				return binarySearch(a, low, mid, x);
			}
		}
		if(a[mid] <= a[high]) {
			sortedHalf = 2;
			if(a[mid] <= x && x <= a[high]) {
				return binarySearch(a, mid, high, x);
			}
		}
		
		if(sortedHalf == 1) {
			return circularArraySearch(a, mid, high, x);
		} else {
			return circularArraySearch(a, low, mid, x);
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
			System.out.println("Can't find " + x);
			return -1;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
