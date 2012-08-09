package th.pocket.gems;

public class SmallestDivisible {
	
	public static long findSmallDivisible() {
		// brute force
		for(long i = 20; i < 100000000000l; i+=20) {
			boolean found = true;
			for(int j = 2; j <= 20; j++) {
				if(i % j != 0) {
					found = false; 
					break;
				}
			}
			if(found) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSmallDivisible());
		System.out.println(232792560);
	}

}
