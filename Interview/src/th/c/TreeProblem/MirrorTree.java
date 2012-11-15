package th.c.TreeProblem;

public class MirrorTree {
	// bottom up
	public void mirror(Node node) {
		if(node == null) return;
		mirror(node.left);
		mirror(node.right);
		
		Node tmp = node.left;
		node.left = node.right;
		node.right = tmp;
	}
	
	// upside down
	public void mirror2(Node node) {
		if(node == null || (node.left == null && node.right == null)) 
			return;
		Node tmp = node.left;
		node.left = node.right;
		node.right = tmp;
		
		if(node.left != null) 
			mirror2(node.left);
		if(node.right != null)
			mirror2(node.right);
	}
}
