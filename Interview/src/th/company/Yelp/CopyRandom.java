package th.company.Yelp;

public class CopyRandom {
	class Node {
		Node next;
		Node random;
		int x;
		
		public Node(int x) {
			this.x = x;
			next = null;
			random = null;
		}
	}
	
	public Node copyRandom(Node head) {
		Node curr = head;
		Node next, tmp;
		while(curr != null) {
			tmp = new Node(curr.x);
			next = curr.next;
			tmp.next = next;
			curr.next = tmp;
		}
		// Mark return head;
		Node result = head.next;
		curr = head;
		// Copy random pointer
		while(curr != null) {
			curr.next.random = curr.random;
			curr = curr.next.next;
		}
		curr = head;
		tmp = curr.next;
		while(curr != null && tmp != null) {
			curr.next = curr.next.next;
			curr = curr.next;
			while(tmp.next != null) {
				tmp.next = tmp.next.next;
				tmp = tmp.next;
			}
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
