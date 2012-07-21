package amazon;

public class Sqrt {
	public int sqrt(int x) {
		if(x < 0) throw new ArithmeticException();
		if(x <= 0) return x;
		
		long low = 1;
		long high = x;
		while(true) {
			long mid = (low+high)/2;
			long tmp = mid*mid;
			if(x == tmp) {
				return (int)mid;
			} else if(tmp > x) {
				high = mid;
			} else {
				low = mid;
			}
		}
    }
	
	public double sqrt(double x) {
		if(x < 0) throw new ArithmeticException();
		
		if(x == 0 || x == 1) 
			return x;
		
		double eps = 0.00001;
		double low, high;
		if(x < 1) {
			low = x;
			high = 1;
		} else {
			low = 1;
			high = x;
		}
		
		while(true) {
			double mid = (low+high)/2;
			double tmp = mid*mid;
			if(tmp == x || high-low <= eps) {
				return mid;
			} else if(tmp > x) {
				high = mid;
			} else {
				low = mid;
			}
		}
	}
}
