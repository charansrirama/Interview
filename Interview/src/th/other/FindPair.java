package th.other;

/**
 * shijinliang Feb 7, 2012 Interview
 **/
public class FindPair {

    public static void findPair(int[] input, int target) {
	if (input.length <= 0 || target <= 0)
	    return;
	for (int i = 0; i < input.length; i++) {
	    int re = target - input[i];
	    if (re > 0) {
		for (int j = i + 1; j < input.length; j++) {
		    if(input[j] == re)
			System.out.println(i + "_" + j);
		}
	    }
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	int[] input = new int[] {1,4,3,55,33,2,3};
	findPair(input, 5);
    }

}
