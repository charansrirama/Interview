package th.c.Leetcode.tree;

// AC
public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	
	public boolean isBST(TreeNode node, int min, int max) {
		if(node == null) return true;
		if(node.val < min || node.val > max) 
			return false;
		return isBST(node.left, min, node.val-1) && isBST(node.right, node.val+1, max);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
