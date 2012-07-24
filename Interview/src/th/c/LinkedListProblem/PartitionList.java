package th.c.LinkedListProblem;

public class PartitionList {
	public Node partition(Node head, int x) {
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;
		
		Node curr = head;
		while(curr != null) {
			Node next = curr.next;
			curr.next = null;
			if((Integer)curr.val < x) {
				if(beforeStart == null) {
					beforeStart = curr;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = curr;
					beforeEnd = beforeEnd.next;
				}
			} else {
				if(afterStart == null) {
					afterStart = curr;
					afterEnd = afterStart;
				} else {
					afterEnd.next = curr;
					afterEnd = afterEnd.next;
				}
			}
			curr = next;
		}
		if(beforeStart == null) return afterStart;
		beforeEnd.next = afterStart;
		return beforeStart;
	}
}
