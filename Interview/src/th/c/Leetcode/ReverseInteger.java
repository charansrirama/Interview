package th.c.Leetcode;

public class ReverseInteger {

	public static int reverseBinary(int x) {
		int b = 0;
		while(true) {
			b |= (x&1);
			x >>= 1;
			if(x == 0) break;
			b <<= 1;
		}
		return b;
	}
	
	public static int reverseInteger(int x) {
		int re = 0;
		while(x != 0) {
			re = re*10 + x%10;
			x /= 10;
		}
		return re;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = -12345;
//		System.out.println(Integer.toBinaryString(x));
//		System.out.println(Integer.toBinaryString(-x));
//		System.out.println(Integer.toBinaryString(reverseBinary(-x)));
		System.out.println(reverseInteger(x));
	}

}
