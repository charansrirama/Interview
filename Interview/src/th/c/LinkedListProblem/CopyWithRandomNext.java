package th.c.LinkedListProblem;

public class CopyWithRandomNext {
	public rNode copyList(rNode head) {
		rNode curr = head;
		rNode next, tmp;
		while(curr != null) {
			tmp = new rNode(curr.val);
			tmp.rand = null;
			tmp.next = curr.next;
			next = curr.next;
			curr.next = tmp;
			curr = next;
		}
		// save result pointer
		rNode res = head.next;
		// copy the arbitrary linke for result
		curr = head;
		while(curr != null) {
			curr.next.rand = curr.rand;
			curr = curr.next.next;
		}
		// restore original and cooy linked list
		curr = head;
		tmp = head.next;
		while(curr != null && tmp != null) {
			curr.next = curr.next.next;
			curr = curr.next;
			if(tmp.next != null) {
				tmp.next = tmp.next.next;
				tmp = tmp.next;
			}
		}
		return res;
	}
}

class rNode {
	int val;
	rNode next;
	rNode rand;
	public rNode(int val) {
		this.val = val;
		next = null;
		rand = null;
	}
}