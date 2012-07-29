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
	
	// In-order travel method
	public boolean isBST2(Node root) {
		Node prev = null;
		return helper2(root, prev);
	}
	
	public boolean helper2(Node node, Node prev) {
		if(node != null) {
			if(!helper2(node.left, prev))
				return false;
			if(prev!=null && node.val <= prev.val) 
				return false;
			prev = node;
			return helper2(node.right, prev);
		}
		return true;
	}
	
	
}
