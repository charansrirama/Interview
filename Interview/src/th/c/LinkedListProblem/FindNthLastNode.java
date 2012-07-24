package th.c.LinkedListProblem;

public class FindNthLastNode {
	public Node findNthLastNode(Node head, int n) {
		Node first = head, second = head;
		for(int i = 0; i < n; i++) {
			if(first != null)
				first = first.next;
			else 
				return null;
		}
		while(first != null) {
			first = first.next;
			second = second.next;
		}
		return second;
	}
}
