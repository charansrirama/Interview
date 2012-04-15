package th.leetcode;

public class Sqrt {
	
	// Accepted by Leetcode.com
	// Attention: use long in case of overflow.
	public static int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x < 0) return -1;
        if(x <= 1) return x;
        
        long low = 1;
        long high = x;
        while(true) {
            long mid = (low + high)/2;
            if((x - mid*mid >=0) && (x - mid*mid < (mid+1)*(mid+1)-mid*mid)) {
            	return (int)mid;
            }
            else if(mid*mid < x) {
                low = mid;
            } else {
                high = mid;
            }
        }
	}

	public static double sqrt(double val) {
		if(val < 0) {
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
				double mid = (low + high)/2;
				double tmp = mid*mid;
				if(Math.abs(tmp-val) < eps) {
					return mid;
				}
				if(tmp > val) 
					high = mid;
				else 
					low = mid;
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(sqrt(2));
		System.out.println(sqrt(2147395599));
//		System.out.println(sqrt(4));
//		System.out.println(sqrt(5));
//		System.out.println(sqrt(9));
	}

}
