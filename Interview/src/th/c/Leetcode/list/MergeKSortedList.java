package th.c.Leetcode.list;

import java.util.ArrayList;

public class MergeKSortedList {

	// O(n*lgk)
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if(lists.size() == 0) return null;
		int curSize = lists.size();
		while(curSize > 1) {
			int halfSize = (curSize+1)/2;
			for(int i = 0; i < halfSize && i + halfSize < curSize; i++) {
				ListNode first = lists.get(i);
				ListNode second = lists.get(i+halfSize);
				ListNode result = mergeTwoLists(first, second);
				lists.set(i, result);
			}
			curSize = halfSize;
		}
		return lists.get(0);
    }
	
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
