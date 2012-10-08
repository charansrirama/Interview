package th.c.other;

public class FindMedianInThree {
	
	// Find the median from three number. From Weibo 
	public static int median(int a, int b, int c) {
		if(a > b) {
			if(b > c) return b;
			else return a > c ? c : a;
		} else {
			if(a > c) return a;
			else return b > c ? c : b;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(median(1,2,3));
		System.out.println(median(2,5,4));
		System.out.println(median(2,2,2));
		System.out.println(median(5,4,1));
		System.out.println(median(5,2,4));
	}

}
