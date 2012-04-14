package th.leetcode;

public class AddTwoNumber {

	// Accepted by Leetcode
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode root = new ListNode(-1);
        ListNode temp = root;
        int carry = 0;
                
        while(l1 != null && l2 != null) {
        	int d1 = l1.val;
        	int d2 = l2.val;
        	
        	int tmp = d1+d2+carry;
        	carry = tmp/10;
        	tmp = tmp%10;
        	if(temp.val == -1) {
        		temp.val = tmp;
        	} else {
        		temp.next = new ListNode(tmp);
        		temp = temp.next;
        	}
        	l1 = l1.next;
        	l2 = l2.next;
        }
        
        while(l1 != null) {
        	temp.next = new ListNode((l1.val+carry)%10);
        	carry = (l1.val+carry)/10;
        	temp = temp.next;
        	l1 = l1.next;
        }
        
        while(l2 != null) {
        	temp.next = new ListNode((l2.val+carry)%10);
        	carry = (l2.val+carry)/10;
        	temp = temp.next;
        	l2 = l2.next;
        }
        
        if(carry != 0) {
        	temp.next = new ListNode(carry);
        }
        
        return root;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}

