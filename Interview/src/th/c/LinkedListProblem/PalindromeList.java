package th.c.LinkedListProblem;

import java.util.Stack;

public class PalindromeList {
	public boolean isPalidrome(Node head) {
		Node slow = head;
		Node fast = head;
		Stack<Integer> stack = new Stack<Integer>();
		
		while(fast != null && fast.next != null) {
			stack.push((Integer) slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null) {
			slow = slow.next;
		}
		
		while(slow != null) {
			int top = stack.pop().intValue();
			if(top != (Integer)slow.val) return false;
			slow = slow.next;
		}
		return true;
	}
}
