package th.facebook;

public class Pow {

	public static int pow(int base, int exp) {
		int result = 1;
		while(exp != 0) {
			if((exp & 1) != 0 ) 
				result *= base;
			exp >>= 1;
			base *= base;
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(2, 4));
	}

}
