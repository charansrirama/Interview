package th.c.Leetcode.tree;

import java.util.*;

public class PathSumII {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if(root == null) return results;
		helper(root, sum, new ArrayList<Integer>(), results);
		return results;
	}
	
	private void helper(TreeNode node, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> results) {
		if(node == null) {
			return;
		} else if(node.val == sum && node.left == null && node.right == null) {
			ArrayList<Integer> re = new ArrayList<Integer>();
			for(int i : list) {
				re.add(i);
			}
			re.add(node.val);
			results.add(re);
		} else {
			list.add(node.val);
			helper(node.left, sum - node.val, list, results);
			helper(node.right, sum - node.val, list, results);
			list.remove(list.size()-1);
		}
	}
}
