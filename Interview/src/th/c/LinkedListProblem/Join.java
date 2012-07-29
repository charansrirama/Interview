package th.c.LinkedListProblem;

public class Join {

	public Node joinPoint(Node l1, Node l2) {
		if(l1 == null || l2 == null) return null;
		Node n1 = l1, n2 = l2;
		int length1 = 0, length2 = 0;
		while(n1 != null) {
			length1++;
			n1 = n1.next;
		}
		while(n2 != null) {
			length2++;
			n2 = n2.next;
		}
		n1 = l1; n2 = l2;
		if(length1-length2 > 0) {
			int diff = length1 - length2;
			while(diff != 0) {
				n1 = n1.next;
				diff--;
			}
		} else if(length2 - length1 > 0) {
			int diff = length2 - length1;
			while(diff != 0) {
				n2 = n2.next;
				diff--;
			}
		}
		while(n1 != null && n2 != null) {
			if(n1 == n2) return n1;
			n1 = n1.next;
			n2 = n2.next;
		}
		return null;
	}
}
