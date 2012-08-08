package th.c.String;

public class KMP {

	public static int[] getNext(String str) {
		int len = str.length();
		int[] next = new int[len];
		next[0] = -1;
		int i = 0, j = -1;
		while (i < len - 1) {
			if (-1 == j || str.charAt(i) == str.charAt(j)) {
				i++;
				j++;
				if (str.charAt(i) == str.charAt(j))
					next[i] = next[j];
				else
					next[i] = j;
			} else {
				j = next[j];
			}
		}
		return next;
	}

	public static int kmp(String S, String T, int pos) {
		int[] next = getNext(T);
		int i = pos, j = 0;
		while (i < S.length() - T.length() + 1 && j < T.length()) {
			if (-1 == j || S.charAt(i) == T.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if (j == T.length()) {
			return i - T.length();
		} else
			return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "aaabcabcdeadfskdljfa;lskjdf;kljsdkjfeilskjf";
		String b = "abcabcde";
		System.out.println(kmp(a, b, 0));
	}

}
