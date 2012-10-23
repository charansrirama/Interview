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
	
	public ListNode mergeKLists2(ArrayList<ListNode> lists) {
		if(lists == null || lists.size() == 0) 
			return null;
		if(lists.size() == 1) {
			return lists.get(0);
		} else {
			ListNode head = lists.get(0);
			for(int i = 1; i < lists.size(); i++) {
				head = merge(head, lists.get(i));
			}
			return head;
		}
	}

	private ListNode merge(ListNode root0, ListNode root1) {
		if(root0 == null) return root1;
		if(root1 == null) return root0;
		ListNode head = null;
		ListNode p = null;
		if(root0.val < root1.val) {
			head = new ListNode(root0.val);
			p = head;
			root0 = root0.next;
		} else {
			head = new ListNode(root1.val);
			p = head;
			root1 = root1.next;
		}
		
		while(root0 != null && root1 != null) {
			if(root0.val < root1.val) {
				p.next = new ListNode(root0.val);
				root0 = root0.next;
			} else {
				p.next = new ListNode(root1.val);
				root1 = root1.next;
			} 
			p = p.next;
		}
		
		while(root0!=null) {
			p.next = new ListNode(root0.val);
			p = p.next;
			root0 = root0.next;
		}
		
		while(root1!=null) {
			p.next = new ListNode(root1.val);
			p = p.next;
			root1 = root1.next;
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
