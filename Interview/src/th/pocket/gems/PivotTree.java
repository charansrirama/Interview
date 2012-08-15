package th.pocket.gems;

public class PivotTree {
	public static void pivot(TNode node) {
		if(node == null) return;
		pivot(node.left);
		pivot(node.right);
		
		TNode tmp = node.left;
		node.left = node.right;
		node.right = tmp;
	}
}
