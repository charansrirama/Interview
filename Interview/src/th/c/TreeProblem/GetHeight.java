package th.c.TreeProblem;

import java.util.*;

public class GetHeight {
	public int getHeight(Node node) {
		if(node == null) return 0;
		else 
			return Math.max(getHeight(node.left), getHeight(node.right))+1;
	}
	
	// Non-recursive version
	public static int getHeight2(Node root) {
		if(root == null) return 0;
		int height = 0;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		while(!q.isEmpty()) {
			height++;
			for(int i = 0; i < q.size(); i++) {
				Node t = q.poll();
				if(t.left != null) q.offer(t.left);
				if(t.right != null) q.offer(t.right);
			}
		}
		return height;
	}
}
