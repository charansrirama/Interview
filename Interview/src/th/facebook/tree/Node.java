package th.facebook.tree;

public class Node {
	int number;
	Node parent;
	Node leftChild;
	Node rightChild;

	Node() {
		number = 0;
		leftChild = null;
		rightChild = null;
	}

	Node(int data) {
		number = data;
		leftChild = null;
		rightChild = null;
	}
}
