package th.c.LinkedListProblem;

public class Node {
	Object val;
	Node next;
	
	public Node(Object val) {
		this.val = val;
		next = null;
	}
	
	public Node(Object val, Node next) {
		this.val = val;
		this.next = next;
	}
}
