package th.leetcode;

public class Divide {

	public static int divide(int dividend, int divisor) {
		if(divisor == 0) return -1;
		boolean neg = false;
		if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
			neg = true;
		}
		
		dividend = dividend < 0 ? -dividend : dividend;
		divisor = divisor < 0 ? -divisor : divisor;
		
		int nIter = 0;
		for(int i = 0; i < 32; i++) {
			if(((i<<1)&divisor) != 0) {
				nIter = i;
			}
		}
		
		int uRes = 0;
		
		for(int i = 31-nIter; i >= 0; i--) {
			if((divisor<<i) <= dividend) {
				uRes += (1 << i);
				dividend -= (divisor<<i);
			}
		}
		return uRes;
	}
	
	public static int divide2(int dividend, int divisor) {
		if(divisor == 0) return -1;
		boolean neg = false;
		if(dividend < 0) neg = !neg;
		if(divisor < 0) neg = !neg;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int result = 0;
		while(dividend-divisor>=0) {
			dividend -= divisor;
			result++;
		}
		if(neg) result = -result;
		return result;
	}
	
	public static int divide3(int dividend, int divisor) {
		long a = dividend;
		long b = divisor;
		
		if(b == 0) throw new ArithmeticException();
		boolean neg = false;
		if(a < 0) neg = !neg;
		if(b < 0) neg = !neg;
		
		a = Math.abs(a);
		b = Math.abs(b);
		
		int d = 0;
		while(b<<d <= a) d++;
		int c = 0;
		
		for(int i = d-1; i>=0; i--) {
			if(b<<i <= a) {
				c|=1<<i;
				a-=b<<i;
			}
		}
		if(neg) c = -c;
		return c;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(divide3(8, 2));
	}

}
