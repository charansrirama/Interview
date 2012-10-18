package th.c.StackQueueProblem;

import java.util.Stack;

public class MinStack {

	public Stack<Integer> stack;
	public Stack<Integer> min;
	
	public MinStack() {
		stack = new Stack<Integer>();
		min = new Stack<Integer>();
	}
	
	public boolean empty() {
		return stack.empty();
	}
	
	public void push(int in) {
		if(empty()) {
			stack.push(in);
			min.push(in);
			return;
		}
		stack.push(in);
		if(min.peek() > in) {
			min.push(in);
		}
	}
	
	public int peek() {
		return stack.peek();
	}
	
	public int pop() {
		if(stack.peek() == min.peek()) {
			min.pop();
		}
		return stack.pop();
	}
	
	public int getMin() {
		return min.peek();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinStack test = new MinStack();
		for(int i = 2; i < 5; i++) 
			test.push(i);
		test.push(0);
		System.out.println(test.getMin());
		test.pop();
		System.out.println(test.getMin());
	}

}
