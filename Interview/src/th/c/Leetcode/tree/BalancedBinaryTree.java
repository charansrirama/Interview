package th.c.Leetcode.tree;

// AC
public class BalancedBinaryTree {

	public static int getHeight(TreeNode root) {
		if(root == null) return 0;
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
	
	public boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		return Math.abs(getHeight(root.left)-getHeight(root.right)) <= 1 
				&& isBalanced(root.left) && isBalanced(root.right);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
