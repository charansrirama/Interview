package th.c.LinkedListProblem;

public class FindMiddle {
	
	public static int findMiddle(Node head) {
		Node n = head;
		Node n2 = head;
		while(n2 != null && n2.next != null) {
			n = n.next;
			n2 = n2.next.next;
		}
		return (Integer)n.val;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		System.out.println(findMiddle(head));
	}

}
