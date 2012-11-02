package th.c.other;

public class FindPrimeNumber {
	
	public static void findPrime(int N) {
		for(int i = 2; i <= N; i++) {
			for(int j = 2; j <= (int)Math.sqrt(i)+1; j++) {
				if(i == 2 && j == 2) {
					System.out.print(i + " ");
					continue;
				}
				if(i%j == 0) break;
				
				if(j >= (int)Math.sqrt(i)+1)
					System.out.print(i + " ");
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
