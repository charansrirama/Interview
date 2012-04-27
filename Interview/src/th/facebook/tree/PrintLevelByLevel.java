package th.facebook.tree;

import java.util.*;

public class PrintLevelByLevel {
	
	public static void printLevelByLevel(Node root) {
		if(root == null) {
			System.out.println();
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()) {
			for(int i = 0; i < q.size(); i++) {
				Node t = q.poll();
				if(t.leftChild != null) q.add(t.leftChild);
				if(t.rightChild != null) q.add(t.rightChild);
				System.out.print(t.number + " ");
			}
			System.out.println();
		}
	}
	
	public static void printLevelByLevelZ(Node root) {
		if(root == null) {
			return;
		}
		Stack<Node> current = new Stack<Node>();
		Stack<Node> next    = new Stack<Node>();
		boolean leftToRight = true;
		current.add(root);
		while(!current.isEmpty()) {
			Node tmp = current.pop();
			if(tmp!=null) {
				if(leftToRight) {
					if(tmp.leftChild != null) next.add(tmp.leftChild);
					if(tmp.rightChild != null) next.add(tmp.rightChild);
				} else {
					if(tmp.rightChild!= null) next.add(tmp.rightChild);
					if(tmp.leftChild != null) next.add(tmp.leftChild);
				}
			}
			if(current.isEmpty()) {
				current = next;
				leftToRight = true;
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
