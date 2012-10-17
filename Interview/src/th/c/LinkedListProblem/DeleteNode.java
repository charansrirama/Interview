package th.c.LinkedListProblem;

public class DeleteNode {
	public boolean deleteNode(Node delete) {
		if (delete == null)
			return false;
		if (delete.next == null) {
			delete = null;
			return true;
		} else {
			delete.val = delete.next.val;
			delete.next = delete.next.next;
			return true;
		}
	}
}
