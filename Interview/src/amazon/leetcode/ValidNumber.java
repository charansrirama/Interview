package amazon.leetcode;

public class ValidNumber {
	public boolean isNumber(String s) {
		s = s.trim();
		if(s.charAt(0) == '-' || s.charAt(0) == '+') 
			s = s.substring(1);
		
		boolean num = false;
		boolean dot = false;
		boolean exp = false;
		boolean spa = false;
		
		int i = 0;
		while(i < s.length()) {
			char c = s.charAt(i);
			if(c == ' ') spa = true;
			else if(spa) return false;
			else if(c >= '0' && c <= '9') num = true;
			else if(c == 'e') {
				if(exp || !num) return false;
				exp = true;
				num = false;
			} else if(c == '.') {
				if(exp || dot) return false;
				dot = true;
			} else if(c == '-' || c == '+') {
				if(s.charAt(i-1)!= 'e') return false;
			} else 
				return false;
			i++;
		}
		return num;
	}
}
