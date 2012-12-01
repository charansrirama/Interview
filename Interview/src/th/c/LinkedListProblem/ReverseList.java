package th.c.LinkedListProblem;

public class ReverseList {

	
	public Node reverseList(Node curr, Node prev) {
		if(curr == null) return prev;
		Node next = curr.next;
		curr.next = prev;
		return reverseList(next, curr);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
