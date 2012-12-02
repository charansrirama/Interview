package th.c.company.amzn;

public class ArrayLeftAndRightSum {

	public static int findLeftRightSum(int[] A) {
		if(A == null || A.length == 0) return -1;
		int left = 0, right = 0;
		for(int i = 1; i < A.length; i++) right += A[i];
		for(int i = 0; i < A.length; i++) {
			if(left == right) return A[i];
			else if(i == A.length-1) break;
			else {
				left += A[i]; 
				right -= A[i+1];
			}
		}
		return -1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
