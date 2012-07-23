package th.LinkedListProblem;

public class ReversePartialList {
	public Node reverseBetween(Node head, int m, int n) {
		Node start = head;
		for(int i = 0; i < m-1; i++) 
			start = start.next;
		Node curr = start.next;
		Node prev = null;
		Node next = curr.next;
		int count = 0;
		while(count <= (n-m)) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
			count++;
		}
		start.next.next = curr;
		start.next = prev;
		return head;
	}
}
