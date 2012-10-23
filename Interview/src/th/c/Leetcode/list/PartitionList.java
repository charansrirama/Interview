package th.c.Leetcode.list;

// AC 

public class PartitionList {

	public ListNode partition(ListNode head, int x) {
		ListNode firstStart = null;
		ListNode firstEnd = null;
		ListNode secondStart = null;
		ListNode secondEnd = null;
		while(head != null) {
			ListNode next = head.next;
			head.next = null;
			if(head.val < x) {
				if(firstStart == null) {
					firstStart = new ListNode(head.val);
					firstEnd = firstStart;
				} else {
					firstEnd.next = new ListNode(head.val);
					firstEnd = firstEnd.next;
				}
			} else {
				if(secondStart == null) {
					secondStart = new ListNode(head.val);
					secondEnd = secondStart;
				} else {
					secondEnd.next = new ListNode(head.val);
					secondEnd = secondEnd.next;
				}
			}
			head = next;
		}
		if(firstStart == null) {
			return secondStart;
		} else {
			firstEnd.next = secondStart;
			return firstStart;
		}
	}
}

	