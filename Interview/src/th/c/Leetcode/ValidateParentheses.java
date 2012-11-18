package th.c.Leetcode;

import java.util.*;

public class ValidateParentheses {

	public boolean isValid(String s) {
		if(s.length() %2 != 0) return false;
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++) {
			char t = s.charAt(i);
			if(t == '(' || t == '{' || t == '[')
				stack.push(t);
			else if(t == ')' && !stack.isEmpty()) {
				if(stack.peek()!='(') return false;
				stack.pop();
			} else if(t == '}' && !stack.isEmpty()) {
				if(stack.peek() != '{') return false;
				stack.pop();
			} else if(t == ']' && !stack.isEmpty()) {
				if(stack.peek() != '[') return false;
				stack.pop();
			} else {
				return false;
			}
		}
		return stack.isEmpty();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
