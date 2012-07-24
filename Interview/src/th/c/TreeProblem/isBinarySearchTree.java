package th.c.TreeProblem;

public class isBinarySearchTree {
	public boolean isBST(Node root) {
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean helper(Node node, int min, int max) {
		if(node == null) return true;
		if(node.val > max || node.val < min) return false;
		
		return helper(node.left, min, node.val) && helper(node.right, node.val, max);
	}
}
