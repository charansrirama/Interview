package th.c.TreeProblem;

public class DistanceOfTwoNodes {

	public static int getDistance(Node root, Node a, Node b) {
		Node common = getCommonAncestor(root, a, b);
		//System.out.println(common.val);
		return getDis(common, a) + getDis(common, b);
	}
	
	public static Node getCommonAncestor(Node root, Node a, Node b) {
		if(root == null) return null;
		if(root == a || root == b) return root;
		Node l = getCommonAncestor(root.left, a, b);
		Node r = getCommonAncestor(root.right, a, b);
		if(l != null && r != null) return root;
		return l == null ? r : l;
	}
	
	// s --> t
	public static int getDis(Node s, Node t) {
		if(s == null) return Integer.MIN_VALUE;
		if(s == t) return 0;
		return Math.max(getDis(s.left, t), getDis(s.right, t)) + 1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(5);
		root.left = new Node(1);
		root.right = new Node(3);
		root.left.left = new Node(3);
		root.left.left.left = new Node(4);
		Node a = new Node(7);
		Node b = new Node(9);
		root.left.left.right = a;
		root.right.right = b;
		
		//System.out.println(getDis(root, a));
		//System.out.println(getDis(root, b));
		System.out.println(getDistance(root, a, b));
	}

}
