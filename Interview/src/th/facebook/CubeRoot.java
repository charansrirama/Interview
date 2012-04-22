package th.facebook;

public class CubeRoot {
	public static int cubeRoot(int num) {
		boolean neg = false;
		if(num < 0) {
			neg = true;
			num = -num;
		}
		if(num == 0) return 0;
		
		int low = 1;
		int high = num;
		while(true) {
			int mid = (low + high) /2;
			long tmp = mid*mid*mid;
			if(tmp == num) {
				if(neg) mid = -mid;
				return mid;
			} else if(tmp > num){
				high = mid;
			} else {
				low = mid;
			}
		}
	}
	
	public static double cubeRoot(double num) {
		boolean neg = false;
		if(num < 0) {
			neg = true;
			num = -num;
		}
		
		if(num == 0) return 0;
		
		double low, high;
		double e = 0.0000000001;
		if(num < 1) {
			low = num;
			high = 1;
		} else {
			low = 1;
			high = num;
		}
		while(true) {
			double mid = (low+high)/2;
			double tmp = mid*mid*mid;
			if(tmp == num || high-low <= e) {
				if(neg) mid = -mid;
				return mid;
			} else if(tmp > num) {
				high = mid;
			} else {
				low = mid;
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(cubeRoot(8.99));
	}

}
