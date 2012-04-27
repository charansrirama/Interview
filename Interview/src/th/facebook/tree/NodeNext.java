package th.facebook.tree;

public class NodeNext {

	private static Node getMin(Node n) {
		Node current = n;
		while(current.leftChild != null) {
			current = current.leftChild;
		}
		return current;
	}
	
	public static Node getNext(Node n) {
		if(n.rightChild != null) {
			return getMin(n.rightChild);
		}
		
		Node p = n.parent;
		while(p != null && n == p.rightChild) {
			n = p;
			p = p.parent;
		}
		return p;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
