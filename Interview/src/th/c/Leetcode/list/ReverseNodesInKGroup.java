package th.c.Leetcode.list;

// AC
public class ReverseNodesInKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
		int size = 0; 
		ListNode running = head;
		while(running != null) {
			size++;
			running = running.next;
		}
		if(size < k) {
			return head;
		}
		
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		int count = 0;
		
		while(curr != null && count < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		if(next != null) {
			head.next = reverseKGroup(next, k);
		}
		return prev;
	}
}
