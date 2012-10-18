package th.c.Arrays;

public class IsRotate {
	
	public static boolean isRotate(String s1, String s2) {
		int len = s1.length();
		if(len > 0 && len == s2.length()) {
			String s1s1 = s1+s1;
			return isSubstring(s1s1, s2);
		}
		return false;
	}
	
	public static boolean isSubstring(String s, String t) {
		return false;
	}
}
