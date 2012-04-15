package th.leetcode;

public class ReverseInteger {
	
	public static int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int result = 0;
		int r = 0;
		
		boolean neg = false;
		
		if(x < 0) {
			neg = true;
			x = -x;
		}
		
		while(x > 0) {
			r = x%10;
			x = x/10;
			result = result*10 + r;
		}
		
		if(neg) {
			result = -result;
		}
		
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(reverse(1230));
	}

}
