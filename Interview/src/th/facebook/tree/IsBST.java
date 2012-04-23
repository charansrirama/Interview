package th.facebook.tree;

public class IsBST {
	public static boolean isBST(Node root) {
		return isBSTutil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean isBSTutil(Node node, int min, int max) {
		if(node == null) return true;
		
		if(node.number < min || node.number > max) return false;
		
		return isBSTutil(node.leftChild, min, node.number-1) && 
				isBSTutil(node.rightChild, node.number+1, max);
	}
}
