package th.c.Arrays;

/*
 * Three ways to solve anagram problem
 * 1. Sort strings
 * 2. Use array flag
 * 3. Prime number
 */
public class Anagram {
	
	public static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	public static boolean anagramSort(String s, String t) {
		if(s.length() != t.length()) return false;
		return sort(s).equals(sort(t));
	}
	
	public static boolean anagramFlag(String s, String t) {
		if(s.length() != t.length()) return false;
		int[] flag = new int[256];
		
		for(int i = 0; i < s.length(); i++) {
			flag[s.charAt(i)]++;
		}
		
		for(int i = 0; i < t.length(); i++) {
			flag[t.charAt(i)]--;
		}
		
		for(int i : flag) {
			if(i != 0) return false;
		}
		return true;
	}
	
	public static final int[] prime = {
		2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,  
        61, 67, 71, 73, 79, 83, 89, 97, 101
	};
	
	public static boolean anagramPrime(String s, String t) {
		if(s.length() != t.length()) return false;
		int re = 1;
		for(int i = 0; i < s.length(); i++) {
			int r = s.charAt(i) - 'a';
			re *= prime[r];
		}
		for(int i = 0; i < t.length(); i++) {
			int r = t.charAt(i) - 'a';
			re /= prime[r];
		}
		return re == 1? true : false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
