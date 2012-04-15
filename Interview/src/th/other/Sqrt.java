package th.other;

public class Sqrt {

	public static double sqrt(double val) {
		if(val < 0) {
			System.out.println("Error");
			return -1;
		}
		if(val == 0 || val == 1) return val;
		else {
			double eps = 0.0000001;
			double low, high;
			if(val < 1) {
				low = val;
				high = 1;
			} else {
				low = 1;
				high = val;
			}
			while(true) {
				double mid = (low+high)/2;
				double tmp = mid*mid;
				if(Math.abs(tmp-val) < eps){
					return mid;
				}
				if(tmp > val) {
					high = mid;
				} else {
					low = mid;
				}
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(-100.3E-9);
	}

}
