package amazon.leetcode;

public class MergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null;
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			head = new ListNode(l1.val);
			l1 = l1.next;
		} else {
			head = new ListNode(l2.val);
			l2 = l2.next;
		}
		
		ListNode running = head;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				running.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				running.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			running = running.next;
		}
		while(l2 != null) {
			running.next = new ListNode(l2.val);
			running = running.next;
			l2 = l2.next;
		}
		while(l1 != null) {
			running.next = new ListNode(l1.val);
			running = running.next;
			l1 = l1.next;
		}
		return head;
	}
}
