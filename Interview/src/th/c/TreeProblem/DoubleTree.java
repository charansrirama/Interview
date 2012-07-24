package th.c.TreeProblem;

public class DoubleTree {
	public void doubleTree(Node node) {
		if(node == null) return;
		doubleTree(node.left);
		doubleTree(node.right);
		
		Node tmp = node.left;
		node.left = new Node(node.val);
		node.left.left = tmp;
	}
}
