package th.c.LinkedListProblem;

public class ReverseKNodes {
	public Node reverseKGroup(Node head, int k) {
		int size = 0;
		Node running = head;
		while(running != null) {
			running = running.next;
			size++;
		}
		if(size < k) 
			return head;
		
		Node curr = head;
		Node prev = null;
		Node next = null;
		int count = 0;
		while(curr != null && count<k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		if(next != null) {
			head.next = reverseKGroup(next, k);
		}
		return prev;
	}
}
