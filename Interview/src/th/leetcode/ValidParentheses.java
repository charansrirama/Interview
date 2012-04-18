package th.leetcode;

import java.util.Stack;

public class ValidParentheses {
	
	// Failed when "([)]"
	public static boolean isValid1(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] flag = new int[6];
        // 0 1 2 3 4 5 
        // ( ) { } [ ]
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if(c == '(') flag[0]++;
        	else if(c == '{') flag[2]++;
        	else if(c == '[') flag[4]++;
        	else if(c == ')') {
        		if(flag[0] > flag[1]) {
        			flag[1]++;
        		} else {
        			return false;
        		}
        	} else if(c == '}') {
        		if(flag[2] > flag[3]) {
        			flag[3]++;
        		} else {
        			return false;
        		}
        	} else if(c == ']') {
        		if(flag[4] > flag[5]) {
        			flag[5]++;
        		} else {
        			return false;
        		}
        	}
        }
        if(flag[0] != flag[1] || flag[2] != flag[3] || flag[4] != flag[5]){
        	return false;
        } else 
        	return true;
    }
	
	public static boolean isValid(String s) {
		Stack stack = new Stack();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if(stack.isEmpty()) return false;
				else {
					int t = (Character) stack.pop();
					int ri = c;
					if(c == ')'){
						if(t != ri-1) 
							return false;
					} else {
						if(t != ri-2){
							return false;
						}
					}
				}
			}
		}
		if(stack.isEmpty()) return true;
		else 
			return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "(){}[]";
//		for(int i = 0; i < s.length(); i++) {
//			int c = s.charAt(i);
//			System.out.println(s.charAt(i) + " " +c);
//		}
//		for(int i = 0; i <= 125; i++) {
//			System.out.println(i+ " " + ((char)i));
//		}
	    System.out.println(isValid(s));
		
	}

}
