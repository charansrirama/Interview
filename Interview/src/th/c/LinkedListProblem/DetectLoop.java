package th.c.LinkedListProblem;

public class DetectLoop {
	public boolean detectLoop(Node head) {
		if(head == null) return false;
		Node slow = head;
		Node fast = head;
		while(slow!=null && fast!=null&&fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) return true;
		}
		return false;
	}
	
	public Node findCircleStart(Node head) {
		if(head == null) return null;
		Node slow = head, fast = head;
		while(slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) break;
		}
		if(fast == null || fast.next == null) return null;
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}
}
