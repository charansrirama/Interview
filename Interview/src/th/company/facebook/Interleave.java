package th.company.facebook;

public class Interleave {

	public static boolean dfs(String a, String b, String c, int i, int j) {
		if(i+j == c.length()) return true;
		if(i<a.length() && a.charAt(i) == c.charAt(i+j)) {
			if(dfs(a, b, c, i+1, j)) return true;
		}
		if(j<b.length() && b.charAt(j) == c.charAt(i+j)) {
			if(dfs(a, b, c, i, j+1)) return true;
		}
		return false;
	}
	
	public static boolean isInterLeave(String a, String b, String c) {
		if(a == null || b == null || c == null || a.length()+b.length() != c.length()) 
			return false;
		return dfs(a, b, c, 0, 0);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
