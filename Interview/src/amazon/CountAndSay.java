package amazon;

public class CountAndSay {

	public static String countAndSay(int n) {
		String num = "1";
		for(int i = 1; i < n; i++) {
			System.out.println(num);
			num = solve(num);
		}
		return num;
	}
	
	public static String solve(String num) {
		StringBuilder result = new StringBuilder();
		char repeat = num.charAt(0);
		num = num.substring(1) + " ";
		int times = 1;
		for(char c : num.toCharArray()) {
			if(c == repeat) {
				times++;
			} else {
				result.append(times);
				result.append(repeat);
				repeat = c;
				times = 1;
			}
		}
		return result.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}

}
