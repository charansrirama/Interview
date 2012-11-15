package th.c.PointToOffer;

public class BST2List {

	public static TreeNode BST2List(TreeNode root) {
		if(root == null) return root;
		TreeNode head = helper(root);
		while(head.left != null) 
			head = head.left;
		return head;
	}
	
	private static TreeNode helper(TreeNode node) {
		if(node == null) return null;
		TreeNode left = helper(node.left);
		TreeNode right = helper(node.right);
		if(left != null) {
			while(left.right != null) 
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
