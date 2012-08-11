package th.pocket.gems;

public class LinkedListLoop {
	
	class Node {
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
			next = null;
		}
	}
	
	public static Node isLoop(Node head) {
		Node fast = head, slow = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) return slow;
		}
		return null;
	}
	
	public static Node findLoop(Node head) {
		Node n = head;
		
		Node meet = isLoop(n);
		if(meet == null) return null;
		
		Node slow = head;
		while(slow != meet) {
			slow = slow.next;
			meet = meet.next;
		}
		return meet;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
