package th.c.Leetcode;

public class CountAndSay {
	
	public static String countAndSay(int n) {
		String number = "1";
		for(int i = 1; i < n; i++) {
			number = say(number);
		}
		return number;
    }
	
	public static String say(String num) {
		int count = 1;
		char c = num.charAt(0);
		StringBuilder result = new StringBuilder();
		for(int i = 1; i < num.length(); i++) {
			if(c == num.charAt(i)) {
				count++;
			} else {
				result.append(count);
				result.append(c);
				c = num.charAt(i);
				count = 1;
			}
		}
		result.append(count);
		result.append(c);
		return result.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(10));
	}

}
