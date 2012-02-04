package th.bit;

public class GetOddOne {

	public static int getOddOne(int[] input) {
		int result = input[0];
		for(int i = 1; i < input.length; i++) {
			result ^= input[i];
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = {1,2,2,1,3,3,3,1,1,2,2};
		System.out.println(getOddOne(input));
	}

}
