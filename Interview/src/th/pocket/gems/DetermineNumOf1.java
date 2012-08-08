package th.pocket.gems;

// Determine the number of 1's in binary representation of integer
public class DetermineNumOf1 {
	
	public static int getNums(int n) {
		int result = 0;
		while(n != 0) {
			int t = n%2;
			if(t == 1) result++;
			n /= 2;
		}
		return result;
	}
	
	public static int getNums2(int n) {
		int result = 0;
		while(n != 0) {
			result = (n&1) == 1? result+1 : result;
			n >>= 1;
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getNums(7));
	}

}
