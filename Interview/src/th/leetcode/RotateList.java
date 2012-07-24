package th.leetcode;

import th.c.LinkedListProblem.Node;

public class RotateList {

	public static ListNode rotateList(ListNode head, int n) {
		ListNode first = head, tail = head;
		for(int i = 0; i < n; i++) 
			first = first.next;
		while(first.next != null) {
			first = first.next;
			tail = tail.next;
		}
		ListNode newHead = tail.next;
		tail.next = null;
		first.next = head;
		return newHead;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode current = head;
		for(int i = 2; i <= 5; i++) {
			current.next = new ListNode(i);
			current = current.next;
		}
		head = rotateList(head, 2);
		current = head;
		while(current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		
	}

}
