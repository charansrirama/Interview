package th.c.Leetcode;

public class TrappingRainwater {
	public static int trap(int[] A) {
		int i = 0, j = A.length-1;
		int count = 0;
		
		while(i < j) {
			while(i < j && A[i] < A[i+1]) i++;
			while(i < j && A[j-1] < A[j]) j--;
			if(i == j) break;
			int start, low;
			boolean direct = true;
			if(A[i] <= A[j]) {
				direct = true;
				start = i+1;
				low = A[i];
			} else {
				direct = false;
				start = j-1;
				low = A[j];
			}
			while(A[start] < low) {
				count += low - A[start];
				if(direct) start++;
				else start--;
			}
			if(direct) i = start;
			else j = start;
		}
		
		return count;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
