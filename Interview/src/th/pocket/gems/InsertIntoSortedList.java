package th.pocket.gems;

import th.c.LinkedListProblem.Node;

public class InsertIntoSortedList {
	
	public static LNode insert(LNode head, int val) {
		if(head == null || val <= head.val) {
			LNode tmp = new LNode(val);
			tmp.next = head;
			return tmp;
		}
		
		LNode curr = head;
		LNode prev = null;
		while(curr != null) {
			if(curr.val > val) {
				LNode tmp = new LNode(val);
				tmp.next = prev.next;
				prev.next = tmp;
				prev = prev.next;
				break;
			} 
			prev = curr;
			curr = curr.next;
		}
		if(prev.val < val) {
			LNode tmp = new LNode(val);
			prev.next = tmp;
		}
		return head;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LNode head = new LNode(1);
		head.next = new LNode(2);
		head.next.next = new LNode(3);
		head.next.next.next = new LNode(4);
		head.next.next.next.next = new LNode(5);
		head.next.next.next.next.next = new LNode(7);
		
		head = insert(head, 8);
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

}

class LNode {
	int val;
	LNode next;
	
	public LNode(int v) {
		this.val = v;
		next = null;
	}
}
