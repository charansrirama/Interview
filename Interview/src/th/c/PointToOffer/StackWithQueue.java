package th.c.PointToOffer;

import java.util.*;

public class StackWithQueue<T> {
	
	private Queue<T> queue;
	
	public StackWithQueue() {
		this.queue = new LinkedList<T>();
	}
	
	public void push(T val) {
		queue.offer(val);
	}
	
	public T pop() {
		int size = queue.size();
		for(int i = 0; i < size - 1; i++) 
			queue.offer(queue.poll());
		return queue.poll();
	}
}
