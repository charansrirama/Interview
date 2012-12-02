package th.c.Leetcode.tree;

// AC

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder == null || postorder == null 
				|| inorder.length == 0 || postorder.length == 0) 
			return null;
		return buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
	
	private int getIndex(int[] inorder, int post, int si, int ei) {
		for(int i = si; i <= ei; i++) {
			if(post == inorder[i])
				return i;
		}
		return -1;
	}
	
	private TreeNode buildTree(int[] inorder, int[] postorder, int si, int ei, int sp, int ep) {
		if(si > ei || sp > ep) return null;
		if(si == ei || sp == ep) {
			return new TreeNode(postorder[ep]);
		} else {
			TreeNode root = new TreeNode(postorder[ep]);
			int index = getIndex(inorder, postorder[ep], si, ei);
			if(index == -1) return null;
			int offset = index - si;
			root.left = buildTree(inorder, postorder, si, si+offset-1, sp, sp+offset-1);
			root.right = buildTree(inorder, postorder, si+offset+1, ei, sp+offset, ep-1);
			return root;
		}
	}
	
	public static void main(String[] args) {
		ConstructBinaryTreeFromInorderAndPostorderTraversal t = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
		t.buildTree(new int[]{1,2}, new int[]{2,1});
	}
}
