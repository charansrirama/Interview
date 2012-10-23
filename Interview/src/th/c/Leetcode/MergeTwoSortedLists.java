package th.c.Leetcode;

// AC
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		ListNode head = null;
		ListNode p = null;
		
		if(l1.val < l2.val) {
			head = new ListNode(l1.val);
			p = head;
			l1 = l1.next;
		} else {
			head = new ListNode(l2.val);
			p = head;
			l2 = l2.next;
		}
		
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				p.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				p.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			p = p.next;
		}
		
		while(l1 != null) {
			p.next = new ListNode(l1.val);
			p = p.next;
			l1 = l1.next;
		}
		
		while(l2 != null) {
			p.next = new ListNode(l2.val);
			p = p.next;
			l2 = l2.next;
		}
		
		return head;
	}
}
