package th.c.Leetcode;

import java.util.*;

public class MergeKList {

	public static ListNode mergeKLists(ArrayList<ListNode> lists) {
		Comparator<ListNode> comparator = new NodeComparator();
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(100,
				comparator);
		ListNode head = null;
		ListNode current = null;
		for (ListNode node : lists) {
			if(node != null)
				queue.add(node);
		}
		while (queue.size() != 0) {
			ListNode tmp = queue.poll();
			if(head == null) {
				current = new ListNode(tmp.val);
				head = current;
			} else {
				current.next = new ListNode(tmp.val);
				current = current.next;
			}
			if (tmp.next != null) {
				queue.add(tmp.next);
			}
		}

		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		n1.next = new ListNode(5);
		n1.next.next = new ListNode(10);
		ListNode n2 = n1;
		n1 = n1.next;
		System.out.println(n2.next.val + n1.val);
//		ArrayList<ListNode> list = new ArrayList<ListNode>();
//		list.add(n1);
//		ListNode head = mergeKLists(list);
//		while(head != null) {
//			System.out.print(head.val + "#");
//			head = head.next;
//		}
	}

}

class NodeComparator implements Comparator<ListNode> {

	@Override
	public int compare(ListNode l1, ListNode l2) {
		if (l1.val < l2.val)
			return -1;
		if (l1.val > l2.val)
			return 1;
		return 0;
	}

}
