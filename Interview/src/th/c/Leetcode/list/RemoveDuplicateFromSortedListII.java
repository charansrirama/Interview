package th.c.Leetcode.list;

import java.util.*;

// AC
public class RemoveDuplicateFromSortedListII {

	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode p = head;
		ListNode nh = null;
		ListNode c = null;
		HashSet<Integer> set = new HashSet<Integer>();
		while(p.next != null) {
			if(p.val == p.next.val) {
				set.add(p.val);
			}
			p = p.next;
		}
		p = head;
		while(p != null) {
			if(!set.contains(p.val)) {
				if(nh == null) {
					nh = new ListNode(p.val);
					c = nh;
				} else {
					c.next = new ListNode(p.val);
					c = c.next;
				}
			}
			p = p.next;
//			if(set.contains(p.val)) {
//				if(c == null) {
//					head = p.next;
//				} else {
//					c.next = p.next;
//				}
//				if(c == null) {
//					p = head;
//				} else {
//					p = c.next;
//				}
//			} else {
//				c = p;
//				p = p.next;
//			}
		}
		return nh;
	}
}
