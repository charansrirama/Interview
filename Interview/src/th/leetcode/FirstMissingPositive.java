package th.leetcode;

public class FirstMissingPositive {

	public static int firstMissingPositive(int[] A) {
		if (A.length == 0)
			return 1;
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > max)
				max = A[i];
		}
		int[] flag = new int[max + 1];
		int result = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0)
				flag[A[i]] = 1;
		}
		for (int i = 1; i < flag.length; i++) {
			if (flag[i] == 0) {
				result = i;
				break;
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int A[] = new int[] { 1000, -1 };
		System.out.println(firstMissingPositive(A));
	}

}
