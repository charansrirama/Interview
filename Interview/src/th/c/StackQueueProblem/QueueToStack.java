package th.c.StackQueueProblem;

import java.util.*;

public class QueueToStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		System.out.println(stack.peek());
		while (!stack.isEmpty()) {
			System.out.println(stack.poll());
		}
	}

}

class MyStack<T> {
	Queue<T> q;

	public MyStack() {
		q = new LinkedList<T>();
	}

	public boolean isEmpty() {
		return q.isEmpty();
	}

	public void push(T v) {
		q.offer(v);
	}

	public void shiftQueue() {
		for (int i = 0; i < q.size() - 1; i++) {
			q.offer(q.poll());
		}
	}

	public T peek() {
		shiftQueue();
		T v = q.poll();
		q.offer(v);
		return v;
	}

	public T poll() {
		shiftQueue();
		return q.poll();
	}

	public int size() {
		return q.size();
	}

}