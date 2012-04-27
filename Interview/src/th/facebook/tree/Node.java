package th.facebook.tree;

public class Node {
	int number;
	Node parent;
	Node leftChild;
	Node rightChild;

	Node() {
		number = 0;
		parent = null;
		leftChild = null;
		rightChild = null;
	}

	Node(int data) {
		number = data;
		parent = null;
		leftChild = null;
		rightChild = null;
	}
}
