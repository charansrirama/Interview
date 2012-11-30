package th.c.LinkedListProblem;

import java.util.*;

public class RemoveDuplicate {

	public Node removeDuplicate(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node n = head;
		while(n != null && n.next != null) {
			Node runner = n;
			while(runner.next != null) {
				if(runner.next.val == n.val) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			n = n.next;
		}
		return head;
	}
	
	public Node removeDuplicateUnsorted(Node head) {
		if(head == null || head.next == null) return head;
		Node n = head;
		Node prev = null;
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		while(n != null) {
			if(table.containsKey(n.val)) {
				prev.next = n.next;
			} else {
				table.put((Integer) n.val, true);
				prev = n;
			}
			n = n.next;
		}
		return head;
	}
	
	public Node removeDupUnsorted(Node head) {
		if(head == null || head.next == null) return head;
		Node curr = head;
		while(curr != null) {
			Node running = curr;
			while(running.next != null) {
				if(running.next.val == curr.val) running.next = running.next.next;
				else running = running.next;
			}
			curr = curr.next;
		}
		return head;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
