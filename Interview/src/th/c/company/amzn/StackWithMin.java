package th.c.company.amzn;

import java.util.*;
// 实现O(1)时间返回最小值的栈
public class StackWithMin {

	Stack<Integer> stack;
	Stack<Integer> minStack;
	
	public StackWithMin() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	
	public void push(int v) {
		stack.push(v);
		if(minStack.peek() > v) minStack.push(v);
	}
	
	public int pop() {
		int v = stack.pop();
		if(v == minStack.peek()) minStack.pop();
		return v;
	}
	
	public int getMin() {
		return minStack.peek();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
