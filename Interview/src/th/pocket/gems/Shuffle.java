package th.pocket.gems;

import java.util.Random;

public class Shuffle {

	public static void shuffle(LNode head, int size) {
		LNode n = head;
		Random random = new Random();
//		random.nextInt();
		for(int i = 0; i < size; i++) {
			int change = random.nextInt(size-i);
			LNode c = n;
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
		LNode head = new LNode(1);
		head.next = new LNode(2);
		head.next.next = new LNode(3);
		head.next.next.next = new LNode(4);
		head.next.next.next.next = new LNode(5);
		head.next.next.next.next.next = new LNode(6);
		System.out.println(head);
		shuffle(head, 6);
		System.out.println(head);
	}

}
