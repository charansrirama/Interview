package th.c.LinkedListProblem;

public class DeleteNode {
	public boolean deleteNode(Node delete) {
		if(delete == null || delete.next == null) return false;
		Node next = delete.next;
		delete.val = next.val;
		delete.next = next.next;
		return true;
	}
}
