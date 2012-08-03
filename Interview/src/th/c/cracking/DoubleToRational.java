package th.c.cracking;

public class DoubleToRational {

	private static int gcd(int a, int b) {
		int remainder = a%b;
		if(remainder == 0) 
			return b;
		else 
			return gcd(b, remainder);
	}
	
	public static String getRational(double a) {
		boolean neg = a < 0;
		a = a<0?-a:a;
		int tenPoly = 1;
		while(a*tenPoly - (int)(a*tenPoly) != 0)
			tenPoly *= 10;
		
		int divident = (int)(a*tenPoly);
		int divisor = tenPoly;
		
		int gcd = 0;
		if(divident > divisor) gcd = gcd(divident, divisor);
		else gcd = gcd(divisor, divident);
		
		divident /= gcd;
		divisor /= gcd;
		
		String output = a + " = ";
		if(divisor > 0)
			output += divident + "/" + divisor;
		else 
			output += "-" + divident + "/" + (0-divisor);
		return neg?'-'+output:output;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(getRational(0.125));
//		System.out.println(getRational(-0.125));
//		System.out.println(getRational(3.25));
		System.out.println(getRational(-8.9));
	}

}
