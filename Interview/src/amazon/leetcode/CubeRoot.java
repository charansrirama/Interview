package amazon.leetcode;

public class CubeRoot {
	public int cuberoot(int x) {
		if(x == 0) return 0;
		boolean neg = false;
		if(x < 0) {
			x = -x;
			neg = true;
		}
		int low = 1, high = x;
		while(true) {
			int mid = (low+high)/2;
			if(mid*mid*mid == x) {
				if(neg) mid = -mid;
				return mid;
			} else if(mid*mid*mid > x) 
				high = mid;
			else 
				low = mid;
		}
	}
	
	public double cubroot(double x) {
		if(x == 0) return 0;
		boolean neg = false;
		if(x < 0) {
			x = -x;
			neg = true;
		}
		
		double low, high;
		if(x >= 1) {
			low = 1;
			high = x;
		} else {
			low = x;
			high = 1;
		}
		double esp = 0.00000000001;
		while(true) {
			double mid = (low+high)/2;
			if(x == mid*mid*mid || high-low <= esp) {
				if(neg) mid = -mid;
				return mid;
			} else if(mid*mid*mid > x) {
				high = mid;
			} else{
				low = mid;
			}
		}
	}
	
	public static void main(String args[]) {
		CubeRoot test = new CubeRoot();
		System.out.println(test.cubroot(0.125));
	}
}
