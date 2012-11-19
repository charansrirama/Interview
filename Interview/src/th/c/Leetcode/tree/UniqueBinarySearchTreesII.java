package th.c.Leetcode.tree;

import java.util.*;

// AC
public class UniqueBinarySearchTreesII {
	
	public ArrayList<TreeNode> generateTrees(int n) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		generateBST(list, 1, n);
		return list;
	}
	
	private void generateBST(ArrayList<TreeNode> trees, int start, int end) {
		if(start > end) {
			TreeNode root = null;
			trees.add(root);
		}
		for(int i = start; i <= end; i++) {
			ArrayList<TreeNode> left_tree = new ArrayList<TreeNode>();
			generateBST(left_tree, start, i-1);
			for(int j = 0; j < left_tree.size(); j++) {
				TreeNode left = left_tree.get(j);
				ArrayList<TreeNode> right_tree = new ArrayList<TreeNode>();
				generateBST(right_tree, i+1, end);
				for(int k = 0; k < right_tree.size(); k++) {
					TreeNode right = right_tree.get(k);
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					trees.add(root);
				}
			}
		}
	}
}
