package th.TreeProblem;

public class LowestCommonAncestorInBinaryTree {
	public Node LCAinBT(Node root, Node p, Node q) {
		if(root == null) return root;
		if(root == p || root == q) return root;
		Node l = LCAinBT(root.left, p, q);
		Node r = LCAinBT(root.right, p, q);
		
		if(l==null && r==null) return root;
		return (l == null) ? r : l;
	}
}
