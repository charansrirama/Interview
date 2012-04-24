package th.leetcode;

public class CountAndSay {

	public static String countAndSay(int n) {
		int[] flag = new int[10];
		int temp = 0;
		while(n > 0) {
			temp = n%10;
			n = n/10;
			flag[temp]++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < flag.length; i++) {
			if(flag[i] > 0) {
				sb.append(flag[i]);
				sb.append(i);
			}
		}
		return sb.toString();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(countAndSay(12333));
	}

}
