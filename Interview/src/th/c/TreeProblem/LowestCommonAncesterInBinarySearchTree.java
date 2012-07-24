package th.c.TreeProblem;

public class LowestCommonAncesterInBinarySearchTree {
	public Node LCAinBST(Node root, Node p, Node q) {
		if(root == null || p == null || q == null) return null;
		
		if(root.val > p.val && root.val > q.val) {
			return LCAinBST(root.left, p, q);
		} else if(root.val < p.val && root.val < q.val) {
			return LCAinBST(root.right, p, q);
		} else {
			return root;
		}
	}
}
