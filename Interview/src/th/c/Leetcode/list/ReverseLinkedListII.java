package th.c.Leetcode.list;

// AC
public class ReverseLinkedListII {
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null || m > n) 
			return head;
		if(m == n) return head;
		ListNode curr = head;
		ListNode prev = head;
		for(int i = 1; i < m; i++) {
			prev = curr;
			curr = curr.next;
		}
		ListNode c = curr;
		ListNode next = null;
		ListNode p = null;
		for(int i = m; i <= n; i++) {
			next = c.next;
			c.next = p;
			p = c;
			c = next;
		}
		
		curr.next = c;
		if(m == 1) {
            head = p;
		}
		else{
    	    prev.next = p;
		} 
		return head;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		reverseBetween(head, 1, 2);
	}
}
