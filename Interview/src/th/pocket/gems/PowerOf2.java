package th.pocket.gems;

public class PowerOf2 {
	
	public static boolean isPowerOf2(int num) {
		return (num&(num-1)) == 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Case 1:" + isPowerOf2(8));
		System.out.println("Case 2:" + isPowerOf2(10));
		System.out.println("Case 3:" + isPowerOf2(0));
	}

}
