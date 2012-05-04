package th.facebook.tree;


public class LowestAncestor {

	public boolean covers(Node root, Node p) {
		if(root == null )return false;
		if(root == p) return true;
		return covers(root.leftChild, p) || covers(root.rightChild, p);
	}
	
	public Node commonAncestorHelper(Node root, Node p, Node q) {
		boolean is_p_on_left = covers(root.leftChild, p);
		boolean is_q_on_left = covers(root.rightChild, q);
		if(is_p_on_left != is_q_on_left) return root;
		
		Node child = is_p_on_left?root.leftChild:root.rightChild;
		return commonAncestorHelper(child, p, q);
	}
	
	public Node commonAncestor(Node root, Node p, Node q) {
		if(!covers(root, p) || !covers(root, q)) return null;
		return commonAncestorHelper(root, p, q); 
	}
}
