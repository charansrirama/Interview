package th.pocket.gems;

public class CountBIts {
	
	public static int countBits(int n) {
		int count = 0;
		while(n != 0) {
			if((n&1) != 0) {
				count++;
			}
			n >>= 1;
		}
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(countBits(7));
	}

}
