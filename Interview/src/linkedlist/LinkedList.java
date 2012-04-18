package linkedlist;

public class LinkedList {
	
	private ListNode head;
	
	public LinkedList() {
		head = null;
	}
	
	public void add(Object data) {
		ListNode newNode = new ListNode(data);
		if(head == null) {
			head = newNode;
		} else {
			ListNode current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}
	
	// Add new node after index;
	public void addAt(Object data, int index) {
		ListNode newNode = new ListNode(data);
		ListNode current = head;
		for(int i = 0; i < index && current != null; i++) {
			current = current.next;
		}
		newNode.next = current.next;
		current.next = newNode;
	}
	
	public Object get(int index) {
		if(index <= 0) return null;
		
		ListNode current = head;
		for(int i = 1; i < index; i++) {
			if(current.next == null) return null;
			current = current.next;
		}
		return current.val;
	}
	
	public void remove(int index) {
		if(index == 1) { // Delete head
			head = head.next;
		}
		ListNode current = head;
		for(int i = 0; i < index-2 && current != null; i++) {
			current = current.next;
		}
		current.next = current.next.next;
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null) return null;
		
		ListNode first = head;
		ListNode current = head;
		
		for(int i = 0; i < n; i++) {
			if(first.next == null && i == n-1) 
				return head.next;
			else
				first = first.next;
		}
		
		while(first.next != null) {
			first = first.next;
			current = current.next;
		}
		current.next = current.next.next;
		return head;
	}
	
	public ListNode reverse(ListNode head) {
		if(head == null) return head;
		if(head.next == null) return head;
		
		ListNode current = head;
		ListNode next = current.next;
		ListNode loop = null;
		
		while(next != null) {
			current.next = loop;
			loop = current;
			current = next;
			next = next.next;
		}
		head = current;
		head.next = loop;
		
		return head;
	}
	
	public int size(ListNode head) {
		int count = 0;
		ListNode current = head;
		while(current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
	
	public boolean detectLoop(ListNode head) {
		if(head == null) return false;
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) return true;
		}
		return false;
		
	}
	
	public void printer(ListNode node) {
		System.out.print("[ ");
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println("]");
	}
	
	public static void main(String args[]) {
		LinkedList test = new LinkedList();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
				
		test.printer(test.head);
		
		test.head = test.reverse(test.head);
		
		test.printer(test.head);
		
		System.out.println(test.get(3));
	}
}
