package th.c.Leetcode.tree;

// AC
public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p != null && q != null) {
			return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else if(p == null && q == null) {
			return true;
		}
		return false;
    }
}
