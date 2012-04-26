package th.facebook;

public class ModeNumber {

	/*
	 * How to find if a number is present >= (n / 2) times in an array of size n? 
	 */
	public static int modeNumber(int array[]) {
		if(array.length < 2) {
			return array.length;
		}
		int modeNumber[] = new int[2];
		int count = 1;
		int mode = array[0];
		for(int i = 0; i < array.length; i++, count++) {
			if(array[i] != mode) {
				if(--count == 0) {
					mode = array[i];
				}
			}
		}
		int modeCount = 0;
		if(verifyMode(array, mode)) {
			modeNumber[modeCount++] = mode;
		}
		
		if(count == 1 && array[array.length-1] == mode) {
			if(verifyMode(array, array[array.length-2])) {
				modeNumber[modeCount++] = array[array.length-2];
			}
		}
		return modeCount;
	}
	
	private static boolean verifyMode(int array[], int n) {
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == n) {
				count++;
			}
		}
		
		return count >= (array.length)/2;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
