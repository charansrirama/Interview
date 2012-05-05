package th.facebook;

public class LIS {
	
	public static int lis(int[] A) {
		int[] L = new int[A.length];
		L[0] = 1;
		for(int i = 1; i < A.length; i++) {
			int max = 0;
			for(int j = 0; j < i; j++) {
				if(A[j] < A[i] && L[j] > max) {
					max = L[j];
				}
			}
			L[i] = max+1;
		}
		
		int max = 0;
		for(int i = 0; i < L.length; i++) {
			if(L[i] > max) max = L[i];
		}
		
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
