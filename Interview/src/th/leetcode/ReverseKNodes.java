package th.leetcode;

public class ReverseKNodes {
	
	public static ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int size = 0;
        ListNode running = head;
        while(running != null) {
            running = running.next;
            size++;
        }
        // 1->2->3->4->5
        // 1. k = 3, you should return: 3->2->1->4->5, Keep these two lines
        // 2. k = 3, you should return: 3->2->1->5->4, Comment out these two lines.
        if(size < k) {
            return head;
        }
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;
        int count = 0;
        
        while(curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next != null) {
            head.next = reverseKGroup(next, k);
        }
        return prev;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
