package th.c.LinkedListProblem;

import java.util.Random;

public class Shuffle {

	public static void shuffle(Node head, int size) {
		Node n = head;
		Random random = new Random();
//		random.nextInt();
		for(int i = 0; i < size; i++) {
			int change = random.nextInt(size-i);
			Node c = n;
			for(int j = 0; j < change; j++) {
				c = c.next;
			}
			int tmp = (Integer) n.val;
			n.val = c.val;
			c.val= tmp;
			n = n.next;
		}
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
		System.out.println(head);
		shuffle(head, 6);
		System.out.println(head);
	}

}
