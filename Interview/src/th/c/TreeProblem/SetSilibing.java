package th.c.TreeProblem;

import java.util.*;

public class SetSilibing {
	
	public void setSibiling(Node root) {
		if(root != null) 
			helper(root, null);
	}
	
	private void helper(Node node, Node silibing) {
		node.silibing = silibing;
		Node l = node.left;
		Node r = node.right;
		if(l == null && r == null) return;
		
		while(silibing!=null) {
			if(silibing.left != null) { silibing = silibing.left; break; }
			if(silibing.right != null) { silibing = silibing.right; break; }
			silibing = silibing.silibing;
		}
		
		if(r != null) {
			helper(r, silibing);
			silibing = r;
		}
		if(l != null) {
			helper(l, silibing);
		}
	}

	
	public void setSilibing2(Node root) {
		if(root == null) return;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			Node prev = q.poll();
			if(prev.left != null) q.offer(prev.left);
			if(prev.right != null) q.offer(prev.right);
			for(int i = 1; i < size; i++) {
				Node tmp = q.poll();
				if(tmp.left != null) q.offer(tmp.left);
				if(tmp.right != null) q.offer(tmp.right);
				prev.silibing = tmp;
				prev = tmp;
			}
			prev.silibing = null;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
