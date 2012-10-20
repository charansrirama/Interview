package th.c.Leetcode.tree;

import java.util.*;

// AC
public class BinaryTreeLevelOrderTraversalII {

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if(root == null) return results;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
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
			stack.push(result);
		}
		while(!stack.isEmpty()) {
			results.add(stack.pop());
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
