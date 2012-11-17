package th.c.Leetcode.list;

import java.util.Hashtable;

// AC 
public class RemoveDuplicateFromSortedList {
	
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) return head;
		int prev = head.val;
		ListNode run = head.next;
		ListNode result = new ListNode(0);
		ListNode runR = result;
		while(run != null) {
			if(prev != run.val) {
				runR.next = new ListNode(prev);
				runR = runR.next;
			}
			prev = run.val;
			run = run.next;
		}
		runR.next = new ListNode(prev);
		return result.next;
	}
	public static ListNode deleteDuplicates2(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode curr = head;
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		table.put(curr.val, true);
		while(curr.next != null) {
			int tmp = curr.next.val;
			if(table.containsKey(tmp)) {
				curr.next = curr.next.next;
			} else {
				table.put(curr.next.val, true);
				curr = curr.next;
			}
		}
		return head;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		deleteDuplicates(head);
	}
}
