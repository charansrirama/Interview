package th.c.Sorting;

public class FindUnsortedSequence {

	public static void findUnsortedSequence(int[] A) {
		// Find start
		int left = 0, right = 0;
		for(int i = 0; i < A.length-1; i++) {
			if(A[i] > A[i+1]) {
				left = i+1;
				break;
			}
		}
		// Find end
		for(int i = A.length-1; i > 0; i--) {
			if(A[i] < A[i-1]) {
				right = i-1;
				break;
			}
		}
		
		// expand left
		for(int i = left; i >= 0; i--) {
			if(A[i] < A[left]) {
				left = i+1;
				break;
			}
		}
		
		// expand right
		for(int i = right; i < A.length; i++) {
			if(A[i] > A[right]) {
				right = i-1;
				break;
			}
		}
		System.out.println(left + ", " + right);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {1,2,4,7,10,11,7,12,6,7,16,18,19};
		findUnsortedSequence(A);
	}

}
