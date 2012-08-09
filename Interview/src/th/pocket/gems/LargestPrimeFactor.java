package th.pocket.gems;

public class LargestPrimeFactor {
	// Project Euler #3
	public static int largestPrimeFactor(long number) {
		int i;
		for(i = 2; i <= number; i++) {
			if(number%i == 0) {
				number /= i;
				i--;
			}
		}
		return i;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(largestPrimeFactor(600851475143L));
	}

}
