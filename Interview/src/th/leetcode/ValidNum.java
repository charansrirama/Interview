package th.leetcode;

public class ValidNum {

	public static boolean isNumber(String s) {
		s = s.trim();
		if(s.charAt(0) == '-' || s.charAt(0) == '+') s = s.substring(1);
		
		boolean num = false;
		boolean dot = false;
		boolean exp = false;
		boolean spa = false;
		
		int i = 0;
		while(i < s.length()) {
			if(s.charAt(i) == ' ') spa = true;
			else if(spa) return false;
			else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') num = true;
			else if(s.charAt(i) == 'e') {
				if(exp || num == false) return false;
				exp = true;
				num = false;
			} else if(s.charAt(i) == '.') {
				if(exp || dot) return false;
				dot = true;
			} else if(s.charAt(i) == '-' || s.charAt(i) == '+'){
				if(s.charAt(i-1) != 'e') return false;
			} else 
				return false;
			i++;
		}
		return num;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "+1.e-2";
		System.out.println(isNumber(s));
	}

}
