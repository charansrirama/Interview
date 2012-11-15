package th.c.PointToOffer;

public class PrintListFromTailToHead {
	
	public static void printReverse(Node node) {
		if(node == null) return;
		printReverse(node.next);
		System.out.println(node.val);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(5);
		head.next = new Node(4);
		head.next.next = new Node(3);
		printReverse(head);
	}

}
