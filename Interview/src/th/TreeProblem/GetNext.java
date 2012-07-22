package th.TreeProblem;

public class GetNext {
	
	private Node getMin(Node n) {
		Node curr = n;
		while(curr.left!=null) 
			curr = curr.left;
		return curr;
	}
	
	public Node getNext(Node n) {
		if(n == null) return null;
		if(n.parent == null || n.right != null) {
			return getMin(n.right);
		}
		
		Node p = n.parent;
		while(p != null && n != p.left) {
			n = p;
			p = p.parent;
		}
		return p;
	}
}
