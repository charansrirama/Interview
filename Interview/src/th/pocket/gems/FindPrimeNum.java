package th.pocket.gems;

public class FindPrimeNum {

	public static void findPrimeNum(int n) {
		if(n <= 1) return; 
		for(int i = 2; i <= n; i++) {
			if(isPrime(i))
				System.out.println(i);
		}
	}
	
	public static boolean isPrime(int n) {
		for(int i = 2; i <= (int)Math.sqrt(n); i++) {
			if(n%i == 0) return false;
		}
		return true;
	}
	
	// Recursion version
	public static boolean isPrimeR(int n) {
		return helper(n, n-1);
	}
	
	public static boolean helper(int n, int d) {
		if(n == 1 || n == 0) return false;
		if(d == 1) 
			return true;
		else {
			if(n % d == 0) 
				return false;
			else 
				return helper(n, d-1);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		findPrimeNum(19);
		for(int i = 19; i >= 0; i--) 
			System.out.println(i + " " + isPrimeR(i));
	}

}
