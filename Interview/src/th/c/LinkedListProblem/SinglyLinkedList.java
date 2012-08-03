package th.c.LinkedListProblem;

public class SinglyLinkedList {
	Node head;
	int listCount;
	
	public SinglyLinkedList() {
		head = null;
		listCount = 0;
	}
	
	public void add(Object val) {
		if(head == null) {
			head = new Node(val);
			return;
		}
		Node curr = head;
		while(curr.next != null) {
			curr = curr.next;
		}
		curr.next = new Node(val);
		listCount++;
	}
	
	public void add(Object val, int index) {
		if(index == 0) {
			Node tmp = new Node(val);
			tmp.next = head;
			head = tmp;
			return;
		}
		Node curr = head;
		for(int i = 0; i < index-1 && curr.next != null; i++) {
			curr = curr.next;
		}
		Node tmp = new Node(val);
		tmp.next = curr.next;
		curr.next = tmp;
		listCount++;
	}
	
	public Object get(int index) {
		if(index < 0) return null;
		Node curr = head;
		for(int i = 0; i < index; i++) {
			if(curr.next == null) return null;
			curr = curr.next;
		}
		return curr.val;
	}
	
	public boolean remove(int index) {
		if(index < 0 || index > size()) return false;
		
		Node curr = head;
		for(int i = 0; i < index-1; i++) {
			curr = curr.next;
		}
		curr.next = curr.next.next;
		listCount--;
		return true;
	}
	
	public int size() {
		return listCount;
	}
	
	public String toString() {
		Node curr = head;
		String output = "";
		output += "[" + head.val.toString() + "]";
		curr = curr.next;
		while(curr != null) {
			output += "=>[" + curr.val.toString() + "]";
			curr = curr.next;
		}
		return output;
	}
	
	public void reverse() {
		if(head == null) return;
		Node curr, next, prev;
		curr = head;
		next = null;
		prev = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	
	public Node reverse2(Node head) {
		if(head == null || head.next == null) return head;
		
		Node remaining = reverse2(head.next);
		
		Node curr = remaining;
		while(curr.next != null) {
			curr = curr.next;
		}
		
		curr.next = head;
		head.next = null;
		return remaining;
	}
	
	public Node findNthLastNode(Node head, int n) {
		Node first = head, second = head;
		for(int i = 0; i < n; i++) {
			if(first != null)
				first = first.next;
			else 
				return null;
		}
		while(first != null) {
			first = first.next;
			second = second.next;
		}
		return second;
	}
	
	public Node swapPairs(Node head) {
		if(head == null || head.next == null) return head;
		Node prev = null;
		Node curr = head;
		Node next = null;
		int count = 0;
		while(curr!=null && count < 2) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		if(next != null) 
			head.next = swapPairs(next);
		
		return prev;
	}
	
	public Node rotateList(Node head, int n) {
		Node first = head, tail = head;
		for(int i = 0; i < n; i++) 
			first = first.next;
		while(first.next != null) {
			first = first.next;
			tail = tail.next;
		}
		Node newHead = tail.next;
		tail.next = null;
		first.next = head;
		return newHead;
	}
	
	// Remove Nth node from the end
	// 1->2->3->4->5 
	// removeNthFromEnd(head, 2)
	// 1->2->3->5
	public Node removeNthFromEnd(Node head, int n) {
		Node first = head, second = head;
		for(int i = 0; i < n; i++) {
			first = first.next;
		}
		while(first.next != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return head;
	}
	
	// Reverse linked list between [m, n]
	// 1->2->3->4->5
	// reverseBetween(head, 1, 3)
	// 1->4->3->2->5
	public Node reverseBetween(Node head, int m, int n) {
		Node start = head;
		for(int i = 0; i < m-1; i++) 
			start = start.next;
		Node curr = start.next;
		Node prev = null;
		Node next = curr.next;
		int count = 0;
		while(count <= (n-m)) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
			count++;
		}
		start.next.next = curr;
		start.next = prev;
		return head;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList test = new SinglyLinkedList();
//		test.add(10);
//		test.add(9);
//		test.add(8);
//		test.add(7);
//		test.add(6);
		test.add(5);
		test.add(4);
		test.add(3);
		test.add(2);
		test.add(1);
		System.out.println(test.toString());
		test.head = test.reverse2(test.head);
//		test.head = test.reverseBetween(test.head, 1, 3);
		System.out.println(test.toString());
	}
}
