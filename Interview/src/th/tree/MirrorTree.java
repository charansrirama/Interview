package th.tree;

public class MirrorTree {

	public static void mirror(Node node) {
		if (node == null) return;
		
		mirror(node.leftChild);
		mirror(node.rightChild);
		
		Node temp = node.leftChild;
		node.leftChild = node.rightChild;
		node.rightChild = temp;
	}
}
