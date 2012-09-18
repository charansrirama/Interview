package th.c.Recursion;

public class StarString {

	public static void starString(int n) {
		if(n < 0) System.out.println("IllegalArgumentException");
		int size = power(2, n);
		for(int i = 0; i < size; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
	
	public static int power(int base, int n) {
		if(n == 0) return 1;
		if(n == 1) return base;
		if(n%2 == 0) {
			return power(base, n/2)*power(base, n/2);
		} else {
			return power(base, n/2)*power(base, n/2)*base;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power(2, 4));
	}

}
