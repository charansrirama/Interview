package th.c.TreeProblem;

public class IsBalanced {

	class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}
	
	public static int getHeight(Node node) {
		return 0;
	}

	public static boolean isBalanced(Node node) {
		if(node == null) 
			return true;
		else 
			return (isBalanced(node.left) && isBalanced(node.right) && (Math
						.abs(getHeight(node.left) - getHeight(node.right)) <= 1));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
