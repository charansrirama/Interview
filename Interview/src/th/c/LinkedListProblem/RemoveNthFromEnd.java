package th.c.LinkedListProblem;

public class RemoveNthFromEnd {
	public static Node removeNthFromEnd(Node head, int n) {
		Node first = head, second = head;
		for(int i = 0; i < n; i++) {
			first = first.next;
		}
		if(first == null) {
			head.val = head.next.val;
			head.next = head.next.next;
			return head;
		}
		while(first.next != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return head;
	}
	
	public static void printList(Node head) {
		Node n = head;
		while(n != null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		removeNthFromEnd(head, 3);
		printList(head);
	}
}
