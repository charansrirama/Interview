package th.leetcode;

public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return null;

		ListNode first = head;
		ListNode running = head;

		for (int i = 0; i < n; i++) {
			if (first.next == null && i == n - 1)
				return head.next;
			else {
				first = first.next;
			}
		}

		while (first.next != null) {
			first = first.next;
			running = running.next;
		}
		running.next = running.next.next;

		return head;
	}
}
