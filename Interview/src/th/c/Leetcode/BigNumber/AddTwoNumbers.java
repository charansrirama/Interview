package th.c.Leetcode.BigNumber;

public class AddTwoNumbers {

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode result = new ListNode(0);
        ListNode run = result;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int val1 = l1 == null? -1 : l1.val;
            int val2 = l2 == null? -1 : l2.val;
            int cur = 0;
            if(val1 == -1) {
                cur = (val2+carry)%10;
                carry = (val2+carry)/10;
                l2 = l2.next;
            } else if(val2 == -1) {
                cur = (val1+carry)%10;
                carry = (val1+carry)/10;
                l1 = l1.next;
            } else {
                cur = (val1+val2+carry)%10;
                carry = (val1+val2+carry)/10;
                l1 = l1.next; l2 = l2.next;
            }
            run.next = new ListNode(cur);
            run = run.next;
        }
        if(carry != 0) run.next = new ListNode(carry);
        return result.next;
        
    }
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		int carry = 0;
		ListNode head = new ListNode(0);
		ListNode running = head;
		while(l1 != null && l2 != null) {
			running.next = new ListNode((l1.val+l2.val+carry)%10);
			carry = (l1.val+l2.val+carry)/10;
			running = running.next;
			l1 = l1.next; l2 = l2.next;
		}
		while(l1 != null) {
			running.next = new ListNode((l1.val+carry)%10);
			carry = (l1.val+carry)/10;
			running = running.next;
			l1 = l1.next;
		}
		while(l2 != null) {
			running.next = new ListNode((l2.val+carry)%10);
			carry = (l2.val+carry)/10;
			running = running.next;
			l2 = l2.next;
		}
		if(carry != 0) running.next = new ListNode(carry);
		return head.next;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}