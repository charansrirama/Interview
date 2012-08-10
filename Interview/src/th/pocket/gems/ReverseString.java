package th.pocket.gems;

public class ReverseString {

	private static void reverse(char[] str, int start, int end) {
		while(start <= end) {
			char t = str[start];
			str[start] = str[end];
			str[end] = t;
			start++; end--;
		}
	}
	
	public static String reverseString(String s) {
		char[] str = s.toCharArray();
		reverse(str, 0, str.length-1);
		int end = 0, start = 0;
		while(end < str.length) {
			while(end < str.length && str[end] != ' ') {
				end++;
			}
			end--;
			reverse(str, start, end);
			start = end = end+2;
		}
		return new String(str);
	}
	
	public static void main(String[] args) {
		System.out.println(reverseString("hello world"));
		System.out.println(reverseString("hello"));
	}
}
