package th.tree;

public class DoubleTree {
	public static void doubleTree(Node node) {
		if(node == null) return;
		doubleTree(node.leftChild);
		doubleTree(node.rightChild);
		
		Node temp = node.leftChild;
		node.leftChild = new Node(node.number);
		node.leftChild.leftChild = temp;
	}
}
