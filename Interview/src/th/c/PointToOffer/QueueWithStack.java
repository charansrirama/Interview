package th.c.PointToOffer;

import java.util.*;

public class QueueWithStack<T> {

	private Stack<T> que;
	private Stack<T> buf;
	
	public QueueWithStack() {
		this.que = new Stack<T>();
		this.buf = new Stack<T>();
	}
	
	public void appendTail(T val) {
		while(!buf.isEmpty()) {
			que.push(buf.pop());
		}
		que.push(val);
	}
	
	public T deleteHead() {
		if(buf.isEmpty()) 
			while(!que.isEmpty()) 
				buf.push(que.pop());
		return buf.pop();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
