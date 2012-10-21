package th.c.Leetcode.tree;

// AC

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || inorder == null 
				|| preorder.length == 0 || inorder.length == 0) 
			return null;
		return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
	
	private int getIndex(int[] inorder, int pre, int si, int ei) {
		for(int i = si; i <= ei; i++) {
			if(inorder[i] == pre) {
				return i;
			}
		}
		return -1;
	}
	
	private TreeNode buildTree(int[] preorder, int[] inorder, int sp, int ep, int si, int ei) {
		if(sp > ep || si > ei) 
			return null;
		if(sp == ep || si == ei) {
			return new TreeNode(preorder[sp]);
		} else {
			TreeNode root = new TreeNode(preorder[sp]);
			int index = getIndex(inorder, preorder[sp], si, ei);
			int offset = index - si;
			root.left = buildTree(preorder, inorder, sp+1, sp+offset, si, si+offset);
			root.right = buildTree(preorder, inorder, sp+offset+1, ep, index+1, ei);
			return root;
		}
	}
}
