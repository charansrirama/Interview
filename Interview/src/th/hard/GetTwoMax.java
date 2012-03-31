package th.hard;

public class GetTwoMax {
	
	public static int flip(int bit) {
		return 1^bit;
	}
	
	public static int sign(int a) {
		return flip((a>>31)&0x1);
	}
	
	public static int getMax(int a, int b) {
		int c = a-b;
		
		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(c);
		
		int use_sign_of_a = sa^sb;
		
		int use_sign_of_c = flip(sa^sb);
		
		int k = use_sign_of_a*sa + use_sign_of_c*sc;
		int q = flip(k);
		
		return a*k + b*q;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getMax(5,2));
	}

}
