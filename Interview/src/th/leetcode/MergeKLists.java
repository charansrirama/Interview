package th.leetcode;

import java.util.*;

public class MergeKLists {

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Comparator<ListNode> comparator = new NodeComparator();
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(100, comparator);
        ListNode head = null;
        ListNode current = head;
        for(ListNode node:lists) {
        	queue.add(node);
        }
        while(queue.size() != 0) {
        	ListNode tmp = queue.poll();
        	current = new ListNode(tmp.val);
        	current = current.next;
        	if(tmp.next != null) {
        		queue.add(tmp.next);
        	}
        }
        
        return head;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class NodeComparator implements Comparator<ListNode> {

	@Override
	public int compare(ListNode l1, ListNode l2) {
		if(l1.val < l2.val) return -1;
		if(l1.val > l2.val) return 1;
		return 0;
	}
	
}
