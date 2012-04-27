package th.facebook;

public class RightRotate {
	// k = 2;
	// abcd1234 => 34abcd12
	private static void swap(char[] a, int start, int end) {
		while(start <= end) {
			char c = a[start];
			a[start] = a[end];
			a[end] = c;
			start++; end--;
		}
	}

	public static void rightRotate(char[] a, int len, int k) {
		if(len == 0) return;
		k %= len;
		swap(a, 0, a.length-k-1);
		swap(a, a.length-k, a.length-1);
		swap(a, 0, a.length-1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abcd1234";
		char re[] = s.toCharArray();
		rightRotate(re, re.length, 2);
		for(char c : re) {
			System.out.print(c);
		}
	}

}
