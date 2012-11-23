package th.c.company.amzn;

public class FindAppearOnceNumber {

	public static int findAppearOnce(int[] A) {
		if(A == null || A.length == 0 || A.length%2 == 0) 
			throw new IllegalArgumentException();
		int odd = A[0];
		for(int i = 1; i < A.length; i++) {
			odd ^= A[i];
		}
		return odd;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1,2,3,2,3,4,5,5,4};
		System.out.println(findAppearOnce(A));
	}

}
