package th.facebook.tree;

public class LowestCommonAncestor {
	
	public static Node LCA(Node root, Node a, Node b) {
		if(root == null || a == null || b == null) {
			return null;
		}
		if(root.number > a.number && root.number > b.number) {
			return LCA(root.leftChild, a, b);
		} else if(root.number < a.number && root.number < b.number) {
			return LCA(root.rightChild, a, b);
		} else {
			return root;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
