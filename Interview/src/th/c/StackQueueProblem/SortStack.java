package th.c.StackQueueProblem;

import java.util.*;

public class SortStack {

	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> buffer = new Stack<Integer>();
		while(!s.isEmpty()) {
			if(buffer.isEmpty()) buffer.push(s.pop());
			else {
				int tmp = s.pop();
				if(tmp <= buffer.peek()) buffer.push(tmp);
				else {
					while(!buffer.isEmpty() && buffer.peek() < tmp) {
						s.push(buffer.pop());
					}
					buffer.push(tmp);
				}
			}
		}
		return buffer;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 1; i <= 5; i++) s.push(i);
		s.push(8); s.push(6);
		
		Stack<Integer> after = sort(s);
		while(!after.isEmpty()) System.out.println(after.pop());
	}

}
