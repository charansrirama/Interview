package th.pocket.gems;

public class SumOf3and5 {

	// If we list all the natural numbers below 10 that are multiples of 3 or 5,
	// we get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of
	// all the multiples of 3 or 5 below 1000.
	
	// brute force 
	public static int sumOf3and5() {
		int sumOf3 = 0;
		int sumOf5 = 0;

		for (int i = 3; i < 1000; i++) {
			if (i % 3 == 0)
				sumOf3 += i;
			else if (i % 5 == 0)
				sumOf5 += i;
		}
		return sumOf3 + sumOf5;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(sumOf3and5());
	}

}
