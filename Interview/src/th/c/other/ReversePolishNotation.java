package th.c.other;

import java.util.*;

public class ReversePolishNotation {

	public static int reversePolishNotation(LinkedList<String> list) {
		Stack<Integer> stack = new Stack<Integer>();
		int a, b;
		for(String s : list) {
			if(s == "+") {
				b = stack.pop();
				a = stack.pop();
				stack.push(a+b);
			} else if(s == "-") {
				b = stack.pop();
				a = stack.pop();
				stack.push(a-b);
			} else if(s == "*") {
				b = stack.pop();
				a = stack.pop();
				stack.push(a*b);
			} else if(s == "/") {
				b = stack.pop();
				a = stack.pop();
				stack.push(a/b);
			} else {
				stack.push(Integer.parseInt(s));
			}
		}
		return stack.pop();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> list = new LinkedList<String>();
		list.add("4");
		list.add("2");
		list.add("+");
		list.add("8");
		list.add("*");
		System.out.println(reversePolishNotation(list));
	}

}
