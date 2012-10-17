package th.c.String;

public class StringContain {

	public static final int[] prime = {
		2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,  
        61, 67, 71, 73, 79, 83, 89, 97, 101
	};
	
	public static boolean stringContains(String str1, String str2) {
		long product = 1;
		for(int i = 0; i < str1.length(); i++) {
			product *= prime[str1.charAt(i) - 'A'];
		}
		for(int i = 0; i < str2.length(); i++) {
			if(product % prime[str2.charAt(i)- 'A'] != 0) 
				return false;
			product /= prime[str2.charAt(i) - 'A'];
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stringContains("AAB", "A"));
		System.out.println(stringContains("AAB", "AAAA"));
		System.out.println(stringContains("ABCDEFGHIJK", "ADFH"));
		System.out.println(stringContains("AAB", ""));
		System.out.println(stringContains("", "A"));
	}

}
