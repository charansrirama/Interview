package th.leetcode;

import java.util.*;

public class SimplifyPath {

	public static String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(path.length() <= 1) return path;
		if(path.charAt(path.length()-1) == '/') {
			path = path.substring(0, path.length()-1);
		}
		StringBuilder result = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		stack.push(path.charAt(0));
		for(int i = 1; i < path.length(); i++) {
			char t = path.charAt(i);
			if(t == '/') {
				if(stack.peek() != '/'){
					stack.push(t);
				}
			} else if(t == '.') {
				if(i+1 < path.length() && path.charAt(i+1) == '.') {
					i = i+1;
					stack.pop();
					while(!stack.isEmpty()) {
						if(stack.peek() != '/') {
							stack.pop();
						} else 
							break;
					}
				}
			} else {
				stack.push(t);
			}
		}
		while(!stack.isEmpty()) {
			result.insert(0, stack.pop());
		}
		return result.toString();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "/a/./b/../../c/";
		System.out.println(simplifyPath(s));
	}

}
