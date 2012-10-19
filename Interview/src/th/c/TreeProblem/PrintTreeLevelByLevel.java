package th.c.TreeProblem;

import java.util.*;

public class PrintTreeLevelByLevel {
	public void printLevelByLevel(Node node) {
		if (node == null)
			return;

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node n = queue.poll();
				System.out.print(n.val);
				if (node.left != null)
					queue.add(n.left);
				if (node.right != null)
					queue.add(n.right);
			}
			System.out.println();
		}
	}

	public void printLevelByLevelZ(Node node) {
		if (node == null)
			return;
		Stack<Node> curr = new Stack<Node>();
		Stack<Node> next = new Stack<Node>();
		boolean leftToRight = false;
		curr.add(node);
		while (!curr.isEmpty()) {
			Node n = curr.pop();
			System.out.print(n.val);
			if (leftToRight) {
				if (n.left != null)
					next.add(n.left);
				if (n.right != null)
					next.add(n.right);
			} else {
				if (n.right != null)
					next.add(n.right);
				if (n.left != null)
					next.add(n.left);
			}
			if (curr.isEmpty()) {
				curr = next;
				next = new Stack<Node>();
				leftToRight = !leftToRight;
				System.out.println();
			}
		}
	}
	
	public static void printAtLevel(Node root, int level) {
		if(root == null || level <= 0) return;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			level--;
			for(int i = 0; i < size; i++) {
				Node tmp = q.poll();
				if(level == 0) {
					System.out.print(tmp.val + " ");
				}
				if(tmp.left!=null) q.offer(tmp.left);
				if(tmp.right!=null) q.offer(tmp.right);
			}
			if(level == 0) break;
		}
	}
}
