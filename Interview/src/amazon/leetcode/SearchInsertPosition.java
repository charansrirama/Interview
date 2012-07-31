package amazon.leetcode;

public class SearchInsertPosition {
	// AC
	public static int searchInsert(int[] A, int target) {
		int index = -1;
		for(int i = 0; i < A.length; i++) {
			if(A[i] >= target) {
				index = i;
				return index;
			}
		}
		return A.length;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = new int[]{1,3};
		System.out.println(searchInsert(A, 0));
	}

}
