package th.leetcode;

public class RotateList {

	public static ListNode rotateList(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode tail = head;
        ListNode newHead = null;
        for(int i = 0; i < n; i++) {
        	tail = tail.next;
        }
       newHead = tail.next;
       tail.next = null;
       ListNode running = newHead;
       while(running.next != null) {
    	   running = running.next;
       }
       running.next = head;
       return newHead;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode current = head;
		for(int i = 2; i <= 5; i++) {
			current.next = new ListNode(i);
			current = current.next;
		}
		head = rotateList(head, 2);
		current = head;
		while(current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		
	}

}
