package amazon;

public class FirstMissingPositive {

	public static int firstMissingPositive(int[] A) {
		int max = 0;
		for(int i = 0; i < A.length; i++) {
			if(A[i] > max) max = A[i];
		}
		int[] flag = new int[max+1];
		for(int i = 0; i < A.length; i++) {
			if(A[i] > 0) {
				flag[A[i]] = 1;
			}
		}
		for(int i = 1; i < flag.length; i++) {
			if(flag[i] == 0) 
				return i;
		}
		return max+1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstMissingPositive(new int[]{1,2,0}));
	}

}
