package amazon;

public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
		long a = dividend;
		long b = divisor;
		
		boolean neg = false;
		if(a < 0) neg = !neg;
		if(b < 0) neg = !neg;
		a = Math.abs(a); b = Math.abs(b);
		
		int d = 0;
		while(b << d <= a) d++;
		int c = 0;
		for(int i = d-1; i >= 0; i--) {
			if(b << i <= a) {
				c |= 1<<i;
				a -= b<<i;
			}
		}
		if(neg) c = -c;
		return c;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
