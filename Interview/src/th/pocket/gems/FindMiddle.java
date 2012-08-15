package th.pocket.gems;

public class FindMiddle {
	
	public static int findMiddle(LNode head) {
		if(head == null) return -999;
		LNode n = head;
		LNode n2 = head;
		while(n2.next != null && n2.next.next != null) {
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
		LNode head = new LNode(1);
		head.next = new LNode(2);
		head.next.next = new LNode(3);
		head.next.next.next = new LNode(4);
		head.next.next.next.next = new LNode(5);
		head.next.next.next.next.next = new LNode(6);
		System.out.println(findMiddle(head));
	}

}
