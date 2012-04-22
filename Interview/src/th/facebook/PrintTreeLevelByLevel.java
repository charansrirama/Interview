package th.facebook;

import java.util.*;

public class PrintTreeLevelByLevel {
	
	public static void printTree(Node head) {
		if(head == null) return;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(head);

		while(!q.isEmpty()) {
			for(int i = 0; i < q.size(); i++) {
				Node tmp = q.poll();
				System.out.print(tmp.val + " ");
				if(tmp.left != null) 
					q.add(tmp.left);
				if(tmp.right!= null) 
					q.add(tmp.right);
			}
			System.out.println();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Node {
	int val;
	Node left;
	Node right;
	
	public Node(int val) {
		this.val = val;
		left = null;
		right = null;
	}
}