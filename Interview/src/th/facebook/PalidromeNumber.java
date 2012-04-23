package th.facebook;

public class PalidromeNumber {

	public static boolean isPalidrome(int num) {
		if(num < 0) 
			return false;
		int div = 1;
		while(num/div >= 10) {
			div *= 10;
		}
		
		while(num != 0) {
			int l = num/div;
			int r = num%10;
			if(l != r) return false;
			num = (num%div)/10;
			div /= 100;
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		isPalidrome(12321);
	}

}
