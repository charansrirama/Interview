package th.leetcode;

public class CountAndSay {

	public static String countAndSay(int n) {
		String num = "1";
		for(int i = 0; i < n; i++) {
			System.out.println(num);
			num = countAndSay(num);
		}
		
		return num;
    }
	
	public static String countAndSay(String num) {
		StringBuilder result = new StringBuilder();
		char repeat = num.charAt(0);
		num = num.substring(1)+" ";
		int times = 1;
		
		for(char n : num.toCharArray()) {
			if(n == repeat) {
				times++;
			} else {
				result.append(times);
				result.append(repeat);
				times = 1;
				repeat = n;
			}
		}
		return result.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		countAndSay(10);
	}

}
