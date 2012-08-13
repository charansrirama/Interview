package th.pocket.gems;

public class AddLinkedList {

	public static LNode add(LNode l1, LNode l2) {
		LNode result = new LNode(0);
		LNode running = result;
		int val = 0, rem = 0;
		while(l1 != null && l2 != null) {
			val = (l1.val + l2.val + rem)%10;
			rem = (l1.val + l2.val + rem)/10;
			running.val = val;
			running.next = new LNode(0);
			running = running.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		
		while(l1 != null) {
			running.val = (l1.val + rem)%10;
			running.next = new LNode(0);
			rem = (l1.val + rem)/10;
			running = running.next;
		}
		
		while(l2 != null) {
			running.val = (l2.val + rem)%10;
			running.next = new LNode(0);
			rem = (l2.val + rem)/10;
			running = running.next;
		}
		
		if(rem != 0) {
			running.val = rem;
		} else {
			running = result;
			while(running.next != null && running.next.next != null) {
				running = running.next;
			}
			running.next = null;
		}
		
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LNode l1 = new LNode(1);
		l1.next = new LNode(2);
		l1.next.next = new LNode(3);
		
		LNode l2 = new LNode(1);
		l2.next = new LNode(2);
		l2.next.next = new LNode(8);
		
		System.out.println(add(l1, l2));
	}

}
