package th.leetcode;

public class Pow {
	
	public static double pow(double x, int n) {
		if(x == 0) return 0;
		if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1/x;
        if(n < 0) {
        	x = 1/x;
        	n = -n;
        }
		double sum = 1;
		while(n > 0) {
			if(n%2 == 0) {
				x = x*x;
				n /= 2;
			} else {
				sum *= x;
				n--;
			}
		}
		
		return sum;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(pow(2, 15));
	}

}
