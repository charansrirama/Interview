package th.c.TreeProblem;

public class LowestCommonAncestorInBinaryTree {
	public Node LCAinBT(Node root, Node p, Node q) {
		if(root == null) return null;
		if(root == p || root == q) return root;
		Node l = LCAinBT(root.left, p, q);
		Node r = LCAinBT(root.right, p, q);
		
		if(l==null && r==null) return root; // p and q is on both sides
		return (l == null) ? r : l;
	}
}
