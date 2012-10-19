package th.c.Recursion;

public class MagicIndex {

	public int magicIndex(int[] array, int start, int end) {
		if(end < start || start < 0 || end >= array.length) {
			return -1;
		}
		int mid = (start + end)/2;
		if(mid == array[mid]) 
			return mid;
		else if(array[mid] > mid) {
			return magicIndex(array, start, mid-1);
		} else {
			return magicIndex(array, mid+1, end);
		}
	}
	
	public int magicIndex2(int[] array, int start, int end) {
		if(end < start || start < 0 || end >= array.length) {
			return -1;
		}
		int mid = (start + end)/2;
		if(mid == array[mid])
			return mid;
		
		int leftIndex = Math.min(mid-1, array[mid]);
		int left = magicIndex2(array, start, leftIndex);
		if(left >= 0) return left;
		
		int rightIndex = Math.max(mid+1, array[mid]);
		int right = magicIndex2(array, rightIndex, end);
		return right;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
