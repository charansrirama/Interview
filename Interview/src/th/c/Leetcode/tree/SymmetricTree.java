package th.c.Leetcode.tree;

// AC

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		return helper(root, root);
	}
	
	private boolean helper(TreeNode p, TreeNode q) {
		if(p == null && q == null) 
			return true;
		else if(p == null || q == null)
			return false;
		else 
			return p.val == q.val && helper(p.left, q.right) && helper(p.right, q.left);
	}
}
