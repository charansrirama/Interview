package th.c.Leetcode.list;

public class RemoveNthFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || n <= 0) {
			return null;
		}
		ListNode f = head;
		ListNode e = head;
		int len = 0;
		while(f != null) {
			len++;
			f = f.next;
		}
		if(len < n) return head;
		for(int i = 0; i < n; i++) {
			f = f.next;
		}
		if(f == null) return head.next;
		while(f.next != null) {
			e = e.next;
			f = f.next;
		}
		e.next = e.next.next;
		return head;
	}
}
