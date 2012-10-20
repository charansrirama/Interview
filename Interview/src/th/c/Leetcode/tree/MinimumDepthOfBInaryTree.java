package th.c.Leetcode.tree;

import java.util.*;

// AC
public class MinimumDepthOfBInaryTree {

	public static int minDepth(TreeNode root) {
		if(root == null) return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		int length = 0;
		while(!q.isEmpty()) {
			length++;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				TreeNode tmp = q.poll();
				if(tmp.left == null && tmp.right == null) return length;
				if(tmp.left != null) q.offer(tmp.left);
				if(tmp.right != null) q.offer(tmp.right);
			}
		}
		return length;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.left = new TreeNode(6);
		System.out.println(minDepth(root));
	}

}
