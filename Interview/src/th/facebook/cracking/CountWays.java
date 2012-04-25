package th.facebook.cracking;

public class CountWays {

	public static int countWays(int n) {
		int[] array = new int[n+1];
		array[0] = 1;
		for(int i = 1; i <= n; i++) {
			if(i <= 3) array[i] = i;
			else {
				array[i] = array[i-1] + array[i-2] + array[i-3];
			}
		}
		return array[n];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(countWays(100));
	}

}
