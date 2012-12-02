package th.c.company.amzn;

public class ReverseSentence {

	public static void swap(char[] T, int s, int e) {
		while(s <= e) {
			char tmp = T[s];
			T[s] = T[e];
			T[e] = tmp;
			s++; e--;
		}
	}
	
	public static String reverseSentence(String str) {
		if(str == null || str.length() == 0) return str;
		char[] T = str.toCharArray();
		swap(T, 0, T.length-1);
		int s = 0, e = 0;
		int len = T.length;
		while(e < len) {
			while(e < len && T[e] != ' ') e++;
			e--;
			swap(T, s, e);
			s = e+2;
			e = e+2;
		}
		return new String(T);
	}
	
	public static void main(String[] args) {
		String str = "    hello    world   ";
		String str2 = "hello";
		System.out.println(reverseSentence(str));
	}
}
