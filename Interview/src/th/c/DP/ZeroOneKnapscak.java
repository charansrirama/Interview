package th.c.DP;

import java.util.Arrays;

public class ZeroOneKnapscak {
	public static int zeroOne(int[] values, int[] weights, int capacity) {
		int[] bag = new int[capacity + 1];
		// total weights == capacity if not comment out follow two lines
		Arrays.fill(bag, Integer.MIN_VALUE);
		bag[0] = 0;
		for (int i = 0; i < values.length; i++) {
			for (int j = capacity; j >= weights[i]; j--) {
				int token = bag[j - weights[i]] + values[i];
				if (token > bag[j]) {
					bag[j] = token;
				}
			}
		}
		for (int i = 0; i < bag.length; i++) {
			System.out.print(bag[i] + " ");
		}
		System.out.println();
		return bag[capacity];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int capacity = 165;
		int[] weights = { 164, 23, 31, 29, 44, 53, 38, 63, 85, 89, 82 };
		int[] values = { 1000, 92, 57, 49, 68, 60, 43, 67, 84, 87, 72 };
		System.out.println(zeroOne(values, weights, capacity));
	}

}
