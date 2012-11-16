package th.c.Leetcode;

public class AddTwoNumbers {

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