package th.c.LinkedListProblem;

public class Palindrome {
	
	public static boolean isPalindrome(Node head) {
		if(head == null) return false;
		Node n = head, n2 = head;
		while(n2.next != null && n2.next.next != null) {
			n = n.next;
			n2 = n2.next.next;
		}
		n.next = reverse(n.next);
		n2 = n.next;
		n = head;
		while(n2 != null) {
			if(n.val != n2.val)
				return false;
			n = n.next;
			n2 = n2.next;
		}
		return true;
	}
	
	public static Node reverse(Node head) {
		Node curr = head;
		Node prev = null;
		Node next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
//		head.next.next = new Node(3);
//		head.next.next.next = new Node(4);
//		head.next.next.next.next = new Node(2);
//		head.next.next.next.next.next = new Node(1);
		System.out.println(isPalindrome(head));
	}

}
