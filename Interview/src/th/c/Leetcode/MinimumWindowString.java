package th.c.Leetcode;

public class MinimumWindowString {

	public String minWindow(String S, String T) {
		if(T == null|| S.length() < T.length() || T.length() == 0)
			return "";
		int[] table2 = new int[256];
		for(int i = 0; i < T.length(); i++) 
			table2[T.charAt(i)]++;
		int[] table1 = new int[256];
		int head0 = 0, tail0 = 0, head1 = 0, tail1 = 0;
		while(head1 < S.length()) {
			if(!isSatisfy(table1, table2)) {
				table1[S.charAt(head1++)]++;
			}
			while(isSatisfy(table1, table2) && tail1 < head1) {
				if(head1-tail1 < head0-tail0 || head0 == tail0) {
					tail0 = tail1;
					head0 = tail0;
				}
				table1[S.charAt(tail1++)]--;
			}
		}
		return S.substring(tail0, head0);
    }
	
	public boolean isSatisfy(int[] table1, int[] table2) {
		for(int i = 0; i < table1.length; i++) 
			if(table1[i] < table2[i])
				return false;
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
