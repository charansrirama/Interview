package th.c.LinkedListProblem;

public class RotateList {
	public Node rotateList(Node head, int n) {
		Node first = head, tail = head;
		for(int i = 0; i < n; i++) 
			first = first.next;
		while(first.next != null) {
			first = first.next;
			tail = tail.next;
		}
		Node newHead = tail.next;
		tail.next = null;
		first.next = head;
		return newHead;
	}
}
