package th.c.Leetcode.tree;

import java.util.*;

public class FlattenBinaryTreeToLinkedList {

	// Inorder 
	public TreeNode flatten2(TreeNode root) {
		if(root == null) return null;
		TreeNode head = helper(root);
		while(head.left != null) head = head.left;
		return head;
	}
	
	private TreeNode helper(TreeNode node) {
		if(node == null) return null;
		TreeNode left = helper(node.left);
		TreeNode right = helper(node.right);
		if(left != null) {
			while(left.right!=null) 
				left = left.right;
			left.right = node;
		}
		node.left = left;
		if(right != null) {
			while(right.left != null) 
				right = right.left;
			right.left = node;
		}
		node.right = right;
		return node;
	}
	// Flatten the tree with preorder 
	public void flatten(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		boolean done = false;
		TreeNode curr = root;
		while(!done) {
			if(curr != null) {
				list.add(curr);
				stack.push(curr);
				curr = curr.left;
			} else if(stack.isEmpty()) {
				done = true;
			} else {
				curr = stack.pop();
				curr = curr.right;
			}
		}
		
		for(int i = 0; i < list.size()-1; i++) {
			curr = list.get(i);
			curr.left = null;
			curr.right = list.get(i+1);
		}
		list.get(list.size()-1).left = null;
		list.get(list.size()-1).right = null;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		FlattenBinaryTreeToLinkedList test = new FlattenBinaryTreeToLinkedList();
		TreeNode t = test.flatten2(root);
		while(t != null) {
			System.out.print(t.val + " ");
			t = t.right;
		}
	}
}
