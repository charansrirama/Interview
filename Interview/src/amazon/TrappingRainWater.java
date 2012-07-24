package amazon;

public class TrappingRainWater {
	public int trap(int[] A) {
		int i = 0, j = A.length-1;
		int count = 0;
		while(i<j) {
			while(i<j && A[i] < A[i+1]) {
				i++;
			}
			while(i<j && A[j-1] > A[j]) {
				j--;
			}
			
			if(i == j) break;
			int start, low;
			boolean leftToRight = true;
			if(A[i] <= A[j]) {
				leftToRight = true;
				start = i+1;
				low = A[i];
			} else {
				leftToRight = false;
				start = j-1;
				low = A[j];
			}
			
			while(A[start] < low) {
				count += low-A[start];
				if(leftToRight) start++;
				else start--;
			}
			
			if(leftToRight) i = start;
			else j = start;
		}
		return count;
	}
}
