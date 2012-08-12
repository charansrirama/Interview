package th.c.LinkedListProblem;

public class RemoveDuplicate {

	public Node removeDuplicate(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node n = head;
		while(n != null && n.next != null) {
			Node runner = n;
			while(runner.next != null) {
				if(runner.next.val == n.val) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			n = n.next;
		}
		return head;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
