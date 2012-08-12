package th.pocket.gems;

import java.util.*;

public class QueueWithStack {

	Stack content;
	Stack tmp;

	public QueueWithStack() {
		content = new Stack();
		tmp = new Stack();
	}

	public void enqueue(int val) {
		while (tmp.size() != 0) {
			content.push(tmp.pop());
		}
		content.push(val);
	}

	public int dequeue() {
		while(content.size() != 0) {
			tmp.push(content.pop());
		}
		return tmp.pop();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueWithStack queue = new QueueWithStack();
		queue.enqueue(10);
		queue.enqueue(1);
		queue.enqueue(12);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

}
