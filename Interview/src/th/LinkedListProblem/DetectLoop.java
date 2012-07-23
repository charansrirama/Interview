package th.LinkedListProblem;

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
}
