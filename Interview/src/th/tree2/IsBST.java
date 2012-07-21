package th.tree2;

public class IsBST {

	private boolean isBSTUtil(Node node, int min, int max) {
		if(node == null) {
			return true;
		}
		
		if(node.number < min || node.number > max) {
			return false;
		}
		
		return isBSTUtil(node.leftChild, min, node.number-1) && isBSTUtil(node.rightChild, node.number+1, max);
	}
	
	public boolean isBST(Node node) {
		return isBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
