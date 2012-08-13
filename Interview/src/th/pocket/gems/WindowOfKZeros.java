package th.pocket.gems;

public class WindowOfKZeros {
	
	public static int findMinWindows(int[] input, int k) {
		if(k > input.length) return -1;
		int start = 0;
		int end = 0;
		int len = input.length;
		int count = 0;
		int i = 0;
		int win = 0;
		for(; i < len; i++) {
			if(input[i] == 0) {
				start = i;
				break;
			}
		}
		if(i >= len) return -1;
		count = 1;
		for(i = start+1; i < len; i++) {
			if(input[i] == 0) count++;
			if(count == k) {
				end = i;
				break;
			}
		}
		win = end - start;
		start++; end++;
		while(end < len) {
			while(start <= end && input[start] != 0) {
				start++;
			}
			
			while(end < len && input[end] != 0) {
				end++;
			}
			
			if(end-start < win) {
				win = end - start;
			}
			start++; end++;
		}
		return win+1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {1,0,1,0,0,1,0,1,1,0,0,0};
		System.out.println(findMinWindows(input, 2));
	}

}
