package th.c.Leetcode.tree;

import java.util.*;

// AC
public class BinaryTreeLevelOrderTraversal {

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if(root == null) return results;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			ArrayList<Integer> result = new ArrayList<Integer>();
			for(int i = 0; i < size; i++) {
				TreeNode tmp = q.poll();
				result.add(tmp.val);
				if(tmp.left != null) q.offer(tmp.left);
				if(tmp.right != null) q.offer(tmp.right);
			}
			results.add(result);
		}
		return results;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
