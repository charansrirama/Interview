package th.other;

public class MaxDiff {

	public static void maxDiff(int[] input){
		int start = 0, end = 0;
		int max = 0;
		int maxDiff = 0;
		for (int i = 0; i < input.length; i++) {
			if(input[i] > input[max])
				max = i;
			int diff = input[max] - input[i];
			if (diff > maxDiff) {
				start = max;
				end = i;
				maxDiff = diff;
			}
		}
		System.out.println(input[start] +" " + " " + input[end] + " " + maxDiff);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {7, -8, 2, -2, 1, 0, -6, -3, 8};
		maxDiff(test);
	}

}
