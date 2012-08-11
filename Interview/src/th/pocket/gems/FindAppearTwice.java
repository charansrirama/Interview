package th.pocket.gems;

public class FindAppearTwice {

	// Assume that every number within [1,n] appear once. and one number appear
	// twice. total size n+1;
	public static int appearTwice(int[] input, int n) {
		if (input.length <= 0)
			return -9999;
		int result = input[0];
		for (int i = 1; i < input.length; i++) {
			result ^= input[i];
		}
		for (int i = 1; i <= n; i++) {
			result ^= i;
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 5, 10 };
		System.out.println(appearTwice(input, 10));
	}

}
