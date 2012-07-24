package th.c.LinkedListProblem;

public class RemoveNthFromEnd {
	public Node removeNthFromEnd(Node head, int n) {
		Node first = head, second = head;
		for(int i = 0; i < n; i++) {
			first = first.next;
		}
		while(first.next != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return head;
	}
}
