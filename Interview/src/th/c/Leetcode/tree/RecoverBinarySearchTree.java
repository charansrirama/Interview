package th.c.Leetcode.tree;

import java.util.*;

// AC

public class RecoverBinarySearchTree {
	
	public static void recoverTree(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		stack.push(root);
		TreeNode p = root.left;
		while(!stack.isEmpty()||p!=null) {
			if(p!=null) {
				stack.push(p);
				p = p.left;
			} else {
				p = stack.pop();
				list.add(p);
				p = p.right;
			}
		}
		int first = 0, second = 0;
		for(int i = 0; i < list.size()-1; i++) {
			if(list.get(i).val > list.get(i+1).val) {
				first = i;
				break;
			}
		}
		for(int i = list.size()-1; i>0;i--) {
			if(list.get(i).val < list.get(i-1).val) {
				second = i;
				break;
			}
		}
		int tmp = list.get(first).val;
		list.get(first).val = list.get(second).val;
		list.get(second).val = tmp;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(3);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		recoverTree(root);
	}
}
