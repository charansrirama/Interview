package th.c.StackQueueProblem;

import java.util.Stack;

public class StackToQueue {

}

class MyQueue<T> {
	Stack<T> newData;
	Stack<T> oldData;
	
	public MyQueue() {
		newData = new Stack<T>();
		oldData = new Stack<T>();
	}
	
	public int size() {
		return newData.size() + oldData.size();
	}
	
	public void add(T value) {
		newData.push(value);
	}
	
	public void shiftStacks() {
		if(oldData.isEmpty()) {
			while(!newData.isEmpty()) {
				oldData.push(newData.pop());
			}
		}
	}
	
	public T peek() {
		shiftStacks();
		return oldData.peek();
	}
	
	public T pop() {
		shiftStacks();
		return oldData.pop();
	}
}