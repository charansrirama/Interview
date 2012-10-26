package th.c.Arrays;

import java.util.Random;

public class PickMRandomly {

	public static int[] pickMRandomly(int[] original, int m) {
		int[] set = new int[m];
		Random rand = new Random();
		for(int i = 0; i < m; i++) {
			int index = rand.nextInt(original.length-i);
			set[i] = original[index];
			int tmp = original[index];
			original[index] = original[i];
			original[i] = tmp;
		}
		return set;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
