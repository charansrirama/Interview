package th.pocket.gems;

public class LCA {
	public static int LCA(Node node, int a, int b) {
		if(node == null) return -999;
		if(node.val == a || node.val == b) return node.val;
		int l = LCA(node.left, a, b);
		int r = LCA(node.right, a, b);
		if(l != -999 && r != -999) return node.val;
		return (l == -999) ? r : l;
	}
}

class Node {
	int val;
	Node left, right;
}
