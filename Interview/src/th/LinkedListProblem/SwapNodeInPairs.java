package th.LinkedListProblem;

public class SwapNodeInPairs {
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
}
