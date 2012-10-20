package th.c.Leetcode.tree;

import java.util.*;

//AC

public class BinaryTreeZigzagLevelOrderTraversal {

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if(root == null) return results;
		Stack<TreeNode> curr = new Stack<TreeNode>();
		Stack<TreeNode> next = new Stack<TreeNode>();
		curr.add(root);
		boolean leftToRight = true;
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(!curr.isEmpty()) {
			TreeNode tmp = curr.pop();
			result.add(tmp.val);
			if(leftToRight) {
				if(tmp.left != null) next.push(tmp.left);
				if(tmp.right != null) next.push(tmp.right);
			} else {
				if(tmp.right != null) next.push(tmp.right);
				if(tmp.left != null) next.push(tmp.left);
			}
			if(curr.isEmpty()) {
				results.add(result);
				result = new ArrayList<Integer>();
				curr = next;
				next = new Stack<TreeNode>();
				leftToRight = !leftToRight;
			}
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
