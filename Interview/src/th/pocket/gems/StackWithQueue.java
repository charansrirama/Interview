package th.pocket.gems;

import java.util.*;

// Implement a stack with one queue.
public class StackWithQueue {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack();
		System.out.println(stack.pop()); // Empty case
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		while(stack.size() != 0)
			System.out.println(stack.pop());
	}
}

class Stack {
	Queue<Integer> stack;
	
	public Stack() {
		stack = new LinkedList<Integer>();
	}
	
	public int pop() {
		if(stack.size() == 0) return -999;
		for(int i = 0; i < stack.size()-1; i++) {
			stack.add(stack.poll());
		}
		return stack.poll();
	}
	
	public void push(int val) {
		stack.add(val);
	}
	
	public int size() {
		return stack.size();
	}
}
