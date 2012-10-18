package th.c.Arrays;

/*
 * Given an array, every number appear two times except two numbers appear
 * once. Find these two number
 */
public class FindAppearOnce {

	public static void findOnce(int[] A) {
		int xor = 0;
		int x = 0, y = 0;
		for (int i = 0; i < A.length; i++) {
			xor ^= A[i];
		}

		int setBitNo = xor & ~(xor - 1);
		for (int i = 0; i < A.length; i++) {
			if ((A[i] & setBitNo) == 0) {
				x ^= A[i];
			} else {
				y ^= A[i];
			}
		}

		System.out.println(x + ", " + y);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 2, 3, 7, 9, 11, 2, 3, 11 };
		findOnce(A);
	}

}
