package amazon.leetcode;

// Time limited exceed with large data set.
public class Pow {
	public double pow(double x, int n) {
		if(n < 0) {
			x = 1/x;
			n = -n;
		}
		double result = 1;
		while(n != 0) {
			if((n & 1) != 0) 
				result *= x;
			n >>= 1;
			x *= x;
		}
		return result;
	}
}
