package th.c.PointToOffer;

public class FindAppearMoreThanHalf {
	
	public static int findNum(int[] A) {
		if(A == null || A.length == 0) 
			throw new IllegalArgumentException();
		int result = A[0];
		int times = 1;
		for(int i = 1; i < A.length; i++) {
			if(times == 0) {
				result = A[i];
				times = 0;
			}
			if(result == A[i]) {
				times++;
			} else {
				times--;
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
