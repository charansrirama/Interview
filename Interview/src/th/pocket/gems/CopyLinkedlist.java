package th.pocket.gems;

public class CopyLinkedlist {
	// Copy a linkedlist
	public RandomNode copyLinkedlist(RandomNode head) {
		RandomNode n1 = head;
		RandomNode copy = new RandomNode(n1.val);
		RandomNode n2 = copy;
		while(n1.next != null) {
			n2.next = new RandomNode(n1.next.val);
			n1 = n1.next;
			n2 = n2.next;
		}
		return copy;
	}
	// Copy a linkedlist with random pointer
	public RandomNode copyWithRandom(RandomNode head) {
		RandomNode curr = head;
		RandomNode next, temp;
		while(curr != null) {
			next = curr.next;
			temp = new RandomNode(curr.val);
			temp.next = next;
			curr.next = temp;
			curr = next;
		}
		
		RandomNode copy = head.next;
		curr = head;
		while(curr != null) {
			curr.next.random = curr.random;
			curr = curr.next.next;
		}
		
		curr = head;
		temp = curr.next;
		while(curr != null && temp != null) {
			curr.next = curr.next.next;
			curr = curr.next;
			if(temp.next != null) {
				temp.next = temp.next.next;
				temp = temp.next;
			}
		}
		return copy;
	}
	
	public void print(RandomNode head) {
		RandomNode n = head;
		while(n != null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
		System.out.println();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RandomNode head = new RandomNode(1);
		head.next = new RandomNode(2);
		head.next.next = new RandomNode(3);
		head.next.next.next = new RandomNode(4);
		
		CopyLinkedlist test = new CopyLinkedlist();
		RandomNode h = test.copyLinkedlist(head);
		test.print(h);
	}

}

class RandomNode {
	int val;
	RandomNode next;
	RandomNode random;
	public RandomNode(int v) {
		val = v;
		next = null;
		random = null;
	}
}
