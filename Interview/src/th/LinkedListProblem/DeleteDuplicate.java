package th.LinkedListProblem;

import java.util.*;

public class DeleteDuplicate {
	public void deleteDups(Node head) {
		Hashtable table = new Hashtable();
		Node curr = head;
		Node prev = null;
		while(curr != null) {
			if(table.containsKey(curr.val)) 
				prev.next = curr.next;
			else {
				table.put(curr.val, true);
				prev = curr;
			}
			curr = curr.next;
		}
	}
	
	public void deleteDups2(Node head) {
		Node curr = head;
		while(curr != null) {
			Node runner = curr;
			while(runner.next != null) {
				if(runner.next.val == curr.val) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			curr = curr.next;
		}
	}
}
