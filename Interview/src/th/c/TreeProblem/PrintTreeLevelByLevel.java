package th.c.TreeProblem;

import java.util.*;

public class PrintTreeLevelByLevel {
	public void printLevelByLevel(Node node) {
		if (node == null)
			return;

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while (!queue.isEmpty()) {
			for (int i = 0; i < queue.size(); i++) {
				Node n = queue.poll();
				System.out.println(n.val);
				if (node.left != null)
					queue.add(n.left);
				if (node.right != null)
					queue.add(n.right);
			}
		}
		System.out.println();
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
				leftToRight = !leftToRight;
			}
		}
	}
}
