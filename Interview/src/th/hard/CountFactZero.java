package th.hard;

public class CountFactZero {
	
	// Count the tail zero of num!
	public static int countFactZero(int num) {
		if(num < 0) return -1;
		
		int count = 0;
		
		for(int i = 5; num/i > 0; i *= 5) {
			count += num/i;
		}
		
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(countFactZero(19));
	}

}
