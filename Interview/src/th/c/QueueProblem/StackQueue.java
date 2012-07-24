package th.c.QueueProblem;

import java.util.*;

public class StackQueue {
	Stack<Integer> in;
	Stack<Integer> out;
	int count;
	
	public StackQueue() {
		in = new Stack<Integer>();
		out = new Stack<Integer>();
		count = 0;
	}
	
	public void push(int val) {
		while(!out.isEmpty()) {
			in.push(out.pop());
		}
 		in.push(val);
 		count++;
	}
	
	public int pop() {
		if(!out.isEmpty()) {
			return out.pop();
		}
		while(!in.isEmpty()) {
			out.push(in.pop());
		}
		count--;
		return out.pop();
	}
	
	public boolean isEmpty() {
		return count == 0 ? true : false;
	}
	
	public static void main(String args[]) {
		StackQueue test = new StackQueue();
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		test.push(5);
		System.out.println(test.pop());
		System.out.println(test.pop());
		System.out.println(test.pop());
		test.push(6);
	}
	
}
