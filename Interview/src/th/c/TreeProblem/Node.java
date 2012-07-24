package th.c.TreeProblem;

public class Node {
	int val;
	Node parent;
	Node left;
	Node right;
	
	Node() {
		val = 0;
		parent = null;
		left = null; right = null;
	}
	
	Node(int data) {
		val = data;
		parent = null;
		left = null; right = null;
	}
}
