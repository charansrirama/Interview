package th.c.other;

public class Pow {
	
	public static double pow(double base, int m) {
		if(base == 0) return 0;
		if(m == 0) return 1;
		if(m == 1) return base;
		if(m == -1) return 1/base;
		if(m < 0) {
			base = 1/base;
			m = -m;
		}
		double sum = 1;
		while(m > 0) {
			if(m%2 == 0) {
				base *= base;
				m /= 2;
			} else {
				sum *= base;
				m--;
			}
		}
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
