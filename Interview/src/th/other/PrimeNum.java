package th.other;

public class PrimeNum {

	public static void findPrime(int target) {
		for(int i = 2; i <= target; i++) {
			for(int j = 2; j <= (int)Math.sqrt(i)+1; j++) {
				if(i ==2 && j == 2) {
					System.out.println(j + " is a prime");
					continue;
				}
				if(i%j == 0) break;
				
				if(j >= (int)Math.sqrt(i)+1)
					System.out.println(i + " is a prime");
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		findPrime(100);
	}

}
