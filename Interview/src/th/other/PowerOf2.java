package th.other;

public class PowerOf2 {
	public static boolean isPowerOf2(int n) {
		if(n < 0) return false;
		if((n&(n-1)) == 0)
			return true;
		else 
			return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOf2(3));
	}

}
