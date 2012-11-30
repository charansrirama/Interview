package th.c.Leetcode.tree;

public class MorrisInorderTraversal {

	/*
	 * Inorder Traversal a tree with constant memory space. 
	 * Algorithm:
	 * 1. Initialize current as root 
	 * 2. While current is not NULL
	 *  If current does not have left child
	 *   a) Print current’s data
	 *   b) Go to the right, i.e., current = current->right
	 *  Else
	 *   a) Make current as right child of the rightmost node in current's left subtree
	 *   b) Go to this left child, i.e., current = current->left
	 */
	
	public static void morrisTraversal(TreeNode root) {
		TreeNode curr, prev;
		if (root == null) return;
		curr = root;
		while (curr != null) {
			if(curr.left == null) {
				System.out.println(curr.val);
				curr = curr.right;
			} else {
				prev = curr.left;
				while(prev.right != null && prev.right != curr) prev = prev.right;
				if(prev.right == null) {
					prev.right = curr;
					curr = curr.left;
				} else {
					prev.right = null;
					System.out.println(curr.val);
					curr = curr.right;
				}
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(7);
		morrisTraversal(root);
	}

}
