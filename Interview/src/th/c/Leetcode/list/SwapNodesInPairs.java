package th.c.Leetcode.list;

// AC
public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		int count = 0;
		while(curr != null && count < 2) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		if(next != null) {
			head.next = swapPairs(next);
		}
		return prev;
	}
}
