package th.c.TreeProblem;

public class HasSubTree {

	public static boolean hasSubtree(Node big, Node small) {
		boolean result = false;
		if(big != null && small != null) {
			if(big.val == small.val) {
				result = isSame(big, small);
			}
			if(!result) 
				result = hasSubtree(big.left, small);
			if(!result)
				result = hasSubtree(big.right, small);
		}
		return result;
	}
	
	private static boolean isSame(Node n1, Node n2) {
		if(n2 == null) return true;
		if(n1 == null) return false;
		return n1.val == n2.val && isSame(n1.left, n2.left) && isSame(n1.right, n2.right);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
