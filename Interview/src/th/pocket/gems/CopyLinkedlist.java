package th.pocket.gems;

public class CopyLinkedlist {
	// Copy a linkedlist
	public Node copyLinkedlist(Node head) {
		Node n1 = head;
		Node copy = new Node(n1.val);
		Node n2 = copy;
		while(n1.next != null) {
			n2.next = new Node(n1.next.val);
			n1 = n1.next;
			n2 = n2.next;
		}
		return copy;
	}
	// Copy a linkedlist with random pointer
	public Node copyWithRandom(Node head) {
		Node curr = head;
		Node next, temp;
		while(curr != null) {
			next = curr.next;
			temp = new Node(curr.val);
			temp.next = next;
			curr.next = temp;
			curr = next;
		}
		
		Node copy = head.next;
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
	
	public void print(Node head) {
		Node n = head;
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
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		
		CopyLinkedlist test = new CopyLinkedlist();
		Node h = test.copyLinkedlist(head);
		test.print(h);
	}

}

class Node {
	int val;
	Node next;
	Node random;
	public Node(int v) {
		val = v;
		next = null;
		random = null;
	}
}
