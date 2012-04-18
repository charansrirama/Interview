package th.leetcode;

public class SwapNodeInPairs {
	
	public static ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null || head.next == null) 
        	return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int count = 0;
        while(curr != null && count < 2) {
        	next = curr.next;
        	curr.next = prev;
        	prev = curr;
        	curr = next;
        	count++;
        }
        if(next != null) {
        	head.next = swapPairs(next);
        }
        return prev;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode curr = head;
		for(int i = 2; i <= 5; i++) {
			curr.next = new ListNode(i);
			curr = curr.next;
		}
		ListNode running = swapPairs(head);
		while(running != null) {
			System.out.print(running.val + " ");
			running = running.next;
		}
	}

}
