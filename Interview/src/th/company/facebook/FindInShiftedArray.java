package th.company.facebook;

public class FindInShiftedArray {
	// Find max val in shifted sorted array
	public static int findInShiftedArray(int[] A) {
		if(A== null || A.length == 0) return 0;
		int left = 0, right = A.length-1;
		while(left < right) {
			if(A[left] < A[right]) return A[right]; 
			int mid = (left+right)/2;
			if(A[left] < A[mid]) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return A[left];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findInShiftedArray(new int[]{3,4,5,1,2}));
		System.out.println(findInShiftedArray(new int[]{1,2,3,4,5}));
		System.out.println(findInShiftedArray(new int[]{5,1,2,3,4}));
		System.out.println(findInShiftedArray(new int[]{1,1,2,3,4}));
		System.out.println(findInShiftedArray(new int[]{5,6,4}));
	}

}
