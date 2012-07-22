package th.TreeProblem;

public class MirrorTree {
	public void mirror(Node node) {
		if(node == null) return;
		mirror(node.left);
		mirror(node.right);
		
		Node tmp = node.left;
		node.left = node.right;
		node.right = tmp;
	}
}
