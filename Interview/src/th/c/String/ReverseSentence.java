package th.c.String;

public class ReverseSentence {

	// Not work
	public static void swap(char[] array, int i, int j) {
		char tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void reverse(char[] array, int i, int j) {
		while(i <= j) {
			swap(array, i, j);
			i++; j--;
		}
	}
	
	public static String reverseSentence(String str) {
		if(str == null || str.length() == 0) return str;
		char[] tmp = str.toCharArray();
		reverse(tmp, 0, tmp.length-1);
		int s = 0, e = 0, len = str.length();
		for(int i = 0; i < len; i++) {
			if(str.charAt(i) == ' ') e++;
			else 
				break;
		}
		if(e == len) return str;
		
		while(e < len) {
			if(tmp[e] != ' ') {
				if(s != 0) {
					s = e;
				}
				while(e < len && tmp[e] != ' ') {
					e++;
				}
				int i = 0;
				for(i = e; i < len; i++) {
					if(tmp[i] != ' ') 
						break;
				}
				if(i != len) 
					e--;
				else 
					e = i-1;
				reverse(tmp, s, e);
			}
			e++;
		}
		return new String(tmp);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test1 = "  hello world";
		String test2= "hello world";
		String test3 = "  hello world  ";
		String test4 = "  ";
		String test5 = "hello";
		String test6 = "  hello ";
		
		System.out.println(reverseSentence(test1));
		System.out.println(reverseSentence(test2));
		System.out.println(reverseSentence(test3));
		System.out.println(reverseSentence(test4));
		System.out.println(reverseSentence(test5));
		System.out.println(reverseSentence(test6));
	}

}
