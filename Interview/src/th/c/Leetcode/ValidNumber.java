package th.c.Leetcode;

public class ValidNumber {
	public boolean isNumber(String s) {
		s = s.trim();
		if(s.length() == 0) return false;
		if(s.charAt(0) == '-' || s.charAt(0) == '+')
			s = s.substring(1);
		boolean num = false;
		boolean dot = false;
		boolean exp = false;
		boolean spa = false;
		
		int i = 0; 
		while(i < s.length()) {
			char t = s.charAt(i);
			if(t == ' ') spa = true;
			else if(spa) return false;
			else if(t >= '0' && t <= '9') num = true;
			else if(t == 'e') {
				if(exp || !num) return false;
				exp = true; num = false;
			} else if(t == '.') {
				if(exp || dot) return false;
				dot = true;
			} else if(t == '-' || t == '+') {
				if (i-1 < 0 || s.charAt(i-1) != 'e') return false;
			} else {
				return false;
			}
			i++;
		}
		return num;
	}
}
